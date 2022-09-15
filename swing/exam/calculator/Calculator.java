package swing.exam.calculator;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//-----------------------------------------------------------------------------------------------------------
// public class Calculator extends JFrame implements ActionListener
//-----------------------------------------------------------------------------------------------------------
public class Calculator extends JFrame implements ActionListener {
	
	final	int	MAX_INPUT_LENGTH	= 20;	// 입력할 수 있는 최대 자리 수
	final	int	INPUT_MODE			= 0;	// 입력 상태
	final	int	RESULT_MODE			= 1;	// 출력 상태
	final	int	ERROR_MODE			= 2;	// 에러 상태
	
	int		displayMode;
	
	// 계산기가 처음 시작되거나, 어떤 연산이 끝난 후에 값을 true로 한다.
	// 이때 숫자버튼을 누르면 출력창에 연산 전의 값은 보이지 않게 하고
	// 새로 계산할 숫자를 보여주기 위해서 출력창을 먼저 지운 후에 새로운 숫자를 보여준다.
	// 새로운 숫자를 입력하면 clearOnNextDigit의 값을 false로 만들어야
	// 다음 연산전까지 입력한 숫자를 지우지 않아야 연이어 입력한 숫자가 보여질 수 있다.
	boolean	clearOnNextDigit;
	
	double	lastNumber;	// 연산 전에 저장된 값
	
	// 지금 누른 연산자 바로 전의 연산자를 저장하는 변수
	// 12 + 3 인 상태에서 - 를 누르면 화면에 15를 출력한다.
	// 12 인 상태에서 + 를 누르면 "0"을 가져가 processOperator(String op)를 처리한다.
	// ==> + 를 누른 상태이지만 연산할 값이 하나 밖에 없는 상태이기에 +연산을 할 상태가 아니므로
	//       lastOperator는 "0"이다.
	// 숫자 3을 더 입력한 상태에서 연산자(-)를 누르면 그 전에 입력한,
	// 12 + 3을 처리하기 위해 lastOperator의 값인 +를 가지고 작업을 처리한다.
	String	lastOperator;
	
	private	JLabel	jlbOutput;
	private	JButton	jbtnButtons[];
	private	JPanel	jplMaster, jplBackSpace, jplControl;
	
	Font	f12		= new Font("Times New Roman", 0, 22);
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public Calculator()
	{
		setBackground(Color.GRAY);	// 계산기의 배경색
		
		jplMaster	= new JPanel();
		
		// 출력 창 디자인
		jlbOutput	= new JLabel("0");	// 출력 창 생성
		jlbOutput.setHorizontalTextPosition(JLabel.RIGHT);
		jlbOutput.setBackground(Color.YELLOW);
		jlbOutput.setMinimumSize(new Dimension(100,  40));
		jlbOutput.setPreferredSize(new Dimension(100, 40));
		jlbOutput.setMaximumSize(new Dimension(200, 140));
		jlbOutput.setFont(new Font("Serif", Font.PLAIN, 30));
		jlbOutput.setOpaque(true);	// setOpaque(false) 투명하게
		
		// 가장 윗쪽에 출력 창을 배치한다.
		getContentPane().add(jlbOutput, BorderLayout.NORTH);
		
		// 23개의 모든 버튼을 가리키는 참조 변수
		jbtnButtons	= new JButton[23];
		
		// 버튼들이 올라가 Panel을 생성한다.
		JPanel jplButtons	= new JPanel();
		
		// 숫자 버튼을 만든다.
		for(int i = 0; i <= 9; i++) {
			jbtnButtons[i] = new JButton(String.valueOf(i));
		}
		
		// 각종 기능 버튼을 만든다.
		jbtnButtons[10]	= new JButton("+/-");
		jbtnButtons[11]	= new JButton(".");
		jbtnButtons[12]	= new JButton("=");
		jbtnButtons[13]	= new JButton("/");
		jbtnButtons[14]	= new JButton("*");
		jbtnButtons[15]	= new JButton("-");
		jbtnButtons[16]	= new JButton("+");
		jbtnButtons[17]	= new JButton("sqrt");
		jbtnButtons[18]	= new JButton("1/x");
		jbtnButtons[19]	= new JButton("%");
		
		// 백스페이스 버튼은 별도 Panel에 추가한다.
		jplBackSpace	= new JPanel();
		jplBackSpace.setLayout(new GridLayout(1, 1, 2, 2));
		
		jbtnButtons[20]	= new JButton("BackSpace");
		jplBackSpace.add(jbtnButtons[20]);
		
		// CE, C 버튼은 별도의 Panel에 추가한다.
		jplControl		= new JPanel();
		jplControl.setLayout(new GridLayout(1, 2, 2, 2));
		
		jbtnButtons[21]	= new JButton(" CE ");
		jbtnButtons[22]	= new JButton("C");
		
		jplControl.add(jbtnButtons[21]);
		jplControl.add(jbtnButtons[22]);
		
		// 숫자 버튼들의 글자색은 파란색으로, 기능 버튼들의 글자색은 magenta로 설정한다.
		for(int i = 0; i < jbtnButtons.length; i++) {
			jbtnButtons[i].setFont(f12);
			if(i < 10) {	// 숫자 버튼
				jbtnButtons[i].setForeground(Color.BLUE);
			} else {	// 기능 버튼
				jbtnButtons[i].setForeground(Color.MAGENTA);
			}
		}
		
		// 4 x 5 Grid 형태로 설정한다.
		jplButtons.setLayout(new GridLayout(4, 5, 2, 2)); // (int rows, int cols, int hgap, int vgap)
		
		// 숫자판 맨위 7부터 버튼을 부착한다.
		// 첫번째 줄 (백스페이스, CE, C를 제외한 첫번째 줄
		for(int i = 7; i <= 9; i++) {
			jplButtons.add(jbtnButtons[i]);
		}
		
		// 나누기 버튼과 sqrt버튼을 부착한다.
		jplButtons.add(jbtnButtons[13]);
		jplButtons.add(jbtnButtons[17]);
		
		// 두번째 줄 : 4, 5, 6 버튼을 부착한다.
		for(int i = 4; i <= 6; i++) {
			jplButtons.add(jbtnButtons[i]);
		}
		
		// *, x^2 버튼을 부착한다.
		jplButtons.add(jbtnButtons[14]);
		jplButtons.add(jbtnButtons[18]);
		
		// 세번째 줄 : 1, 2, 3 버튼을 부착한다.
		for(int i = 1; i <= 3; i++) {
			jplButtons.add(jbtnButtons[i]);
		}
		
		// -, % 버튼을 부착한다.
		jplButtons.add(jbtnButtons[15]);
		jplButtons.add(jbtnButtons[19]);

		// 네번째 줄 추가
		// 0, +/-, ., +, = 버튼을 부착한다.
		jplButtons.add(jbtnButtons[0]);
		jplButtons.add(jbtnButtons[10]);
		jplButtons.add(jbtnButtons[11]);
		jplButtons.add(jbtnButtons[16]);
		jplButtons.add(jbtnButtons[12]);
		
		jplMaster.setLayout(new BorderLayout());
		jplMaster.add(jplBackSpace,	BorderLayout.WEST);
		jplMaster.add(jplControl,	BorderLayout.EAST);
		jplMaster.add(jplButtons,	BorderLayout.SOUTH);
		
		// 백스페이스, CE, C, 숫자 및 기능 버튼이 부착되어있는 Panel을 출력 창 아래쪽에 배치한다.
		getContentPane().add(jplMaster, BorderLayout.SOUTH);
		// 포커스를 설정한다.
		requestFocus();
		
		// 각 버튼들에 리스너를 설정한다.
		for(int i = 0; i < jbtnButtons.length; i++) {
			jbtnButtons[i].addActionListener(this);
		}
		
		// 계산기 초기화
		clearAll();
		
		// JFrame의 우측 상단 x버튼 활성화
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // End - 생성자
	
	//-----------------------------------------------------------------------------------------------------------
	// 출력 창에 문자를 출력한다.
	//-----------------------------------------------------------------------------------------------------------
	void setDisplayString(String s) {
		jlbOutput.setText(s);
	}
	//-----------------------------------------------------------------------------------------------------------
	// 출력 창의 값을 가져온다.
	//-----------------------------------------------------------------------------------------------------------
	String getDisplayString() {
		return jlbOutput.getText();
	}
	//-----------------------------------------------------------------------------------------------------------
	// 숫자 키를 누르면 현재 값 뒤에다가 붙여서 output 창에 숫자를 출력한다.
	// 최대 20자(MAX_INPUT_LENGTH)까지
	//-----------------------------------------------------------------------------------------------------------
	void addDigitToDisplay(int digit) {
		
		// clearOnNextDigit
		// 계산기가 처음 시작되거나, 어떤 연산이 끝난 후에 값을 true로 한다.
		// 이때 숫자버튼을 누르면 출력창에 연산 전의 값은 보이지 않게 하고
		// 새로 계산할 숫자를 보여주기 위해서 출력창을 먼저 지운 후에 새로운 숫자를 보여준다.
		// 새로운 숫자를 입력하면 clearOnNextDigit의 값을 false로 만들어야
		// 다음 연산전까지 입력한 숫자를 지우지 않아야 연이어 입력한 숫자가 보여질 수 있다.
		if(clearOnNextDigit) {
			setDisplayString("");	// 출력 창을 지운다.
		}
		
		// 출력 창의 값을 가져온다.
		String inputString	= getDisplayString();
		
		// "ABCDEFGHIJ"
		// substring(2) : index번호 2번 뒤의 모든 값(2번 포함) ==> CDEFGHIJ
		// substring(2, 6) : index번호 2번 부터 6번 전까지 (2 <= index < 6) => CDEF
		
		// 맨 앞에 0이 있으면 0 뒤의 모든 값을 가져온다.
		if(inputString.indexOf("0") == 0) {
			inputString	= inputString.substring(1);
		}
		
		// 변수A.equals(변수B) : 변수A와 변수B가 같다.
		if( (!inputString.equals("0") || digit > 0) && inputString.length() < MAX_INPUT_LENGTH) {
			// 원래 창에 있던 값 뒤에 새로 입력한 값을 붙여서 출력한다.
			setDisplayString(inputString + digit);
		}
		displayMode			= INPUT_MODE;
		clearOnNextDigit	= false;
		
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 출력 창에 소숫점을 찍는다.
	//-----------------------------------------------------------------------------------------------------------
	void addDecimalPoint() {
		displayMode = INPUT_MODE;
		
		if(clearOnNextDigit) {
			setDisplayString("");
		}
		
		String inputString	= getDisplayString();	// 액정의 값을 가져온다.
		
		// 소숫점이 없으면 소숫점을 추가한다. 소숫점은 한번만 찍을 수 있다.
		if(inputString.indexOf(".") < 0)  {	// 소숫점이 한개도 없으면
			setDisplayString(new String(inputString + "."));
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 출력 창의 숫자 부호를 바꾼다.
	//-----------------------------------------------------------------------------------------------------------
	void processSignChange() {
		if(displayMode == INPUT_MODE) {	// 입력모드
			String input = getDisplayString();
			
			// indexOf(String str) : 문자열에서 같은 문자의 위치를 찾는다.
			if(input.length() > 0 && !input.equals("0")) {
				if(input.indexOf("-") == 0) {	// 맨 앞에 -기호가 있다면
					setDisplayString(input.substring(1)); // -를 제거한 나머지 문자열을 출력창에 보여준다.
				} else {	// 출력 창의 값이 양수이면
					setDisplayString("-" + input);	// -를 맨 앞에 붙여서 출력 창에 보여준다.
				}
			}
		} else if(displayMode == RESULT_MODE) {	// 결과모드
			double numberInDisplay = getNumberInDisplay();
			
			if(numberInDisplay != 0) {
				displayResult(-numberInDisplay);
			}
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 계산기 초기화
	//-----------------------------------------------------------------------------------------------------------
	void clearAll() {
		setDisplayString("0");
		lastOperator		= "0";
		lastNumber			= 0;
		displayMode			= INPUT_MODE;
		clearOnNextDigit	= true;
	}

	//-----------------------------------------------------------------------------------------------------------
	// 바로 전에 입력한 값을 지운다. CE 버튼을 누른 경우
	//-----------------------------------------------------------------------------------------------------------
	void clearExisting() {
		setDisplayString("0");
		clearOnNextDigit	= true;
		displayMode			= INPUT_MODE;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 출력 창의 값을 가져온다.
	//-----------------------------------------------------------------------------------------------------------
	double getNumberInDisplay() {
		String input = jlbOutput.getText();
		return Double.parseDouble(input);
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 연산이 끝난 결과를 보여준다.
	//-----------------------------------------------------------------------------------------------------------
	void displayResult(double result) {
		setDisplayString(Double.toString(result));
		lastNumber			= result;
		displayMode			= RESULT_MODE;
		clearOnNextDigit	= true;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 에러 발생시
	//-----------------------------------------------------------------------------------------------------------
	void displayError(String errorMessage) {
		setDisplayString(errorMessage);
		lastNumber			= 0;
		displayMode			= ERROR_MODE;
		clearOnNextDigit	= true;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 사칙연산 버튼을 눌렀을 경우 처리하는 메서드
	// 입력받은 숫자를 처리한다. 한자리씩 입력받아서 계속 누적한다.
	// lastOperator : 지금 누른 연산자 바로 전의 연산자를 저장하는 변수
	// 12 + 3 인 상태에서 - 를 누르면 화면에 15를 출력한다.
	// ==> +를 누른 상태이지만 연산할 값이 하나 밖에 없는 상태이기 때문에 +연산을 할 상태가 아니므로
	//     lastOperator는 "0"이다.
	// 숫자 3을 더 입력한 상태에서 연산자(-)를 누르면, 그 전에 입력한
	// 12 + 3을 처리하기 위해서 lastOperator의 값인 +를 가지고 작업을 처리한다.
	//-----------------------------------------------------------------------------------------------------------
	void processOperator(String op) {
		if(displayMode != ERROR_MODE) {
			double numberInDisplay = getNumberInDisplay();
			System.out.println("lastOperator : " + lastOperator);
			
			if(!lastOperator.equals("0")) {
				try {
					double result = processLastOperator();
					displayResult(result);
					lastNumber = result;
				} catch (DivideByZeroException e) {
				}
			} else {
				// 연산자를 누르면 lastOperator는 0, 화면에 있는 값을 lastNumber에 저장한다.
				lastNumber = numberInDisplay;
			}
			clearOnNextDigit	= true;
			lastOperator		= op;
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// 연산을 처리하는 부분
	//-----------------------------------------------------------------------------------------------------------
	double processLastOperator() throws DivideByZeroException {
		double result			= 0;
		double numberInDisplay	= getNumberInDisplay();	// 두번째 값
		
		if(lastOperator.equals("/")) {
			if(numberInDisplay == 0)
				throw (new DivideByZeroException());
			result	= lastNumber / numberInDisplay;
		}
		if(lastOperator.equals("*")) {
			result	= lastNumber * numberInDisplay;
		}
		if(lastOperator.equals("-")) {
			result	= lastNumber - numberInDisplay;
		}
		if(lastOperator.equals("+")) {
			result	= lastNumber + numberInDisplay;
		}
		
		
		return result;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// = 버튼을 눌렀을 경우 처리하는 메서드
	//-----------------------------------------------------------------------------------------------------------
	void processEquals() {
		double result	= 0;
		
		if(displayMode != ERROR_MODE) {
			try {
				result = processLastOperator();
				displayResult(result);
			} catch (DivideByZeroException e) {
				displayError("0으로 나눌 수 없습니다.");
			}
			lastOperator = "0";
		}
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// public void actionPerformed(ActionEvent e) : 이벤트 처리 부분
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {

		double result = 0;	// 연산 결과를 저장할 변수.
		
		// 각 키별로 이벤트 처리를 한다.
		// 숫자는 기본적으로 화면에 세팅한다.
		// 각 기능키는 각각의 기능을 처리한다.
		for(int i = 0; i < jbtnButtons.length; i++) 
		{
			if(e.getSource() == jbtnButtons[i]) 
			{
				switch(i) {
					case 0:	case 1:	case 2:	case 3: case 4:
					case 5:	case 6:	case 7: case 8: case 9:
						addDigitToDisplay(i);
						break;
						
					case 10:	// +/-
						processSignChange();
						break;
						
					case 11:	// 소숫점
						addDecimalPoint();
						break;
						
					case 12:	// =
						processEquals();
						break;
						
					case 13:	// 나누기
						processOperator("/");
						break;
						
					case 14:	// 곱하기
						processOperator("*");
						break;
						
					case 15:	// 빼기
						processOperator("-");
						break;
						
					case 16:	// 더하기
						processOperator("+");
						break;
						
					case 17:	// sqrt(제곱근)
						if(displayMode != ERROR_MODE) {
							try {
								// root의 -값은 허수이므로 처리가 않된다.
								if(getDisplayString().indexOf("-") == 0) {
									displayError("SQRT에 -값은 사용할 수가 없습니다.");
								}
								result = Math.sqrt(getNumberInDisplay());
								displayResult(result);
							} catch(Exception ex) {
								displayError("SQRT에 유효한 값이 아닙니다.");
								displayMode = ERROR_MODE;
							}
						}
						break;
						
					case 18:	// 1/x (역수 만들기)
						if(displayMode != ERROR_MODE) {
							try {
								if(getNumberInDisplay() == 0) {
									displayError("0으로 나눌 수 없습니다.");
								}
								result = 1 / getNumberInDisplay();
								displayResult(result);
							} catch (Exception ex) {
								displayError("0으로 나눌 수 없습니다.");
								displayMode = ERROR_MODE;
							}
						}
						break;
						
					case 19:	// % (백분율)
						if(displayMode != ERROR_MODE) {
							try {
								result = getNumberInDisplay() / 100;
								displayResult(result);
							} catch (Exception ex) {
								displayError("유효한 값이 아닙니다.");
								displayMode	= ERROR_MODE;
							}
						}
						break;
						
					case 20:	// backspace
						if(displayMode != ERROR_MODE) {
							// 출력 창에 있는 마지막 글자를 제외하고, 출력 창에 다시 보여준다.
							setDisplayString(getDisplayString().substring(0, getDisplayString().length()-1));
							
							// 마지막 남은 1자리를 지우면(backspace), 출력 창에 0으로 보여준다.
							if(getDisplayString().length() < 1) {
								setDisplayString("0");
							}
						}
						break;
						
					case 21:	// CE : 바로 전에 입력한 값만 지운다.
						clearExisting();
						break;
						
					case 22:	// C
						clearAll();
						break;
						
						
				} // End - switch()
			} // End - if
		} // End - for (각 버튼들에 해당하는 이벤트 처리)
		
		
	} // End - public void actionPerformed(ActionEvent e)
	
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Calculator calc = new Calculator();

		calc.setTitle("자바 계산기");
		calc.setSize(441, 417);
		
		calc.pack();
		
		calc.setLocation(500, 200);
		calc.setVisible(true);
		calc.setResizable(false);
		
	} // End - public static void main(String[] args)


} // End - public class Calculator extends JFrame implements ActionListener

//-----------------------------------------------------------------------------------------------------------
// class DivideByZeroException extends Exception
//-----------------------------------------------------------------------------------------------------------
class DivideByZeroException extends Exception {
	
	//-----------------------------------------------------------------------------------------------------------
	// 기본 생성자
	//-----------------------------------------------------------------------------------------------------------
	public DivideByZeroException() {
		super();
		System.out.println("super()");
	}
	//-----------------------------------------------------------------------------------------------------------
	// 매개 변수 있는 생성자
	//-----------------------------------------------------------------------------------------------------------
	public DivideByZeroException(String s) {
		super(s);
		System.out.println("super()");
	}
	
} // End - class DivideByZeroException extends Exception