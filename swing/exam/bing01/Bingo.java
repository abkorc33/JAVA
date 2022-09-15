package swing.exam.bing01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Bingo extends JFrame{
	final int SIZE = 5;	//빙고판의 크기
	JButton[] btnArr = null;	// 25개의 버튼을 만들기 위한 참조변수
	String[] animal = {	// 25개의 버튼 위에 쓰일 글자
			"고양이","강아지","거북이","토끼","사자",
			"호랑이","기린","코끼리","하마","코뿔소",
			"부엉이","돼지","소","펭귄","독수리",
			"타조","캥거루","원숭이","코알라","다람쥐",
			"수달","뱀","양","사슴","닭"
	};
	
	int[] bingNum = new int[SIZE*SIZE];	// 버튼 위치에 숨겨져 있는 숫자를 담을 배열 변수
	int bingoCount = 0;	// 완성된 빙고 라인 수
	// 빙고판의 체크 여부를 확인하기 위한 2차원 배열
	private boolean[][] btnOX = new boolean[SIZE][SIZE];
	
	// 매개변수가 있는 생성자
	Bingo(String title) {
		super("Bingo");
		// 컨텐트팬에 5x5를 사용할 수 있는 작업관리자 실행
		setLayout(new GridLayout(SIZE, SIZE));	
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
	
		// 5x5=25개의 버튼을 담을 객체 배열을 만든다.
		btnArr = new JButton[SIZE * SIZE];	 
		
		// 버튼 위치에 숨겨져 있는 숫자를 담을 배열 변수를 만든다.
		for(int i = 0; i < SIZE*SIZE; i ++) {
			// 버튼에 랜덤한 정수 값을 저장한다.
			bingNum[i] = (int)(Math.random() * (SIZE*SIZE) + 1);
			
			// 똑같은 값이 있으면 숫자를 다시 추출, 중복체크
			if(i > 0) {	// 맨 처음 방의 값은 비교에서 제외.
				// 현재 순번보다 앞의 방들과 값을 비교해 나간다.
				for(int j = 0; j <i; j++) {	
					if(bingNum[j] == bingNum[i]) {	// 방의 값이 같으면
						i--;	// 추출하는 횟수를 1줄인다.
						break;
					}
				}
			}
		}
		
		// 버튼 위치에 숨겨놓은 숫자를 콘솔에 출력한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			System.out.print(bingNum[i] + " ");
		}
		System.out.println();
		
		
		// JFrame에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i] = new JButton(animal[i]);
			btnArr[i].addActionListener(handler);  // 버튼 하나하나에 리스너를 장착시킨다.
			add(btnArr[i]);
		}
		// setBounds = setLocation + setSize위치하고 사이즈 같이 줌(x, y,width, height)
		setBounds(500, 200, 500, 500);	
		setVisible(true);
	}
	
class MyEventHandler extends WindowAdapter implements ActionListener {

	@Override
	public void windowClosing(WindowEvent e) {
		e.getWindow().setVisible(false);
		e.getWindow().dispose();
		System.exit(0);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();	// 눌린 버튼이 어떤 것인지 감지
		
		for(int i = 0; i < SIZE*SIZE; i++) {
			//행 i/SIZE;
			//열 i%SIZE;
			if((JButton)btn == btnArr[i]) {
				System.out.println("눌린번호의 인덱스 번호 :" + i);
				btnArr[i].setFont(new Font("Arial", Font.BOLD + Font.ITALIC, 28));
				btnArr[i].setText(String.valueOf(bingNum[i]));
				// 선택한 버튼을 감지해서 true로 만들고 displayOX에 반영되도록 한다.
				btnOX[i/SIZE][i%SIZE] = true;	// 아래 반복문을 한줄로 만들기
				/*int cnt = 0;
				for(int row = 0; row < SIZE; row++) {
					for(int col = 0; col <SIZE; col++) {
						if(i == cnt) {
							btnOX[row][col] = true;
						}
						cnt++;
					}
				} */
			}
		}
		// 눌린 버튼의 배경색을 변경한다.
		btn.setBackground(Color.ORANGE);
		
		// 빙고가 완성되었는지 검사한다.
		if(checkBingo() == true) {
			System.out.println("축하합니다! All빙고!!");
		}
		// 빙고판의 상태를 콘솔에 출력한다.
		displayOX();
	}
	
}

	public void displayOX() {
		for(int row = 0; row < btnOX.length; row++) {	// 행(위에서 아래)
			for(int col = 0; col < btnOX[row].length; col++) {	// 열(왼쪽에서 오른쪽)
				System.out.print(btnOX[row][col] ? "●" : "x");
			}
			System.out.println();
		}
		System.out.println("현재 맞춘 라인 수 : " + bingoCount);
		System.out.println("=================================");
	}

	boolean checkBingo() {
		this.bingoCount = 0;	//완성된 라인 수
		int garoCount = 0;	// 가로 완성된 개수
		int seroCount = 0;	// 세로 완성된 개수
		int crossCount1 = 0;	// 대각선(↘) 완성 개수
		int crossCount2 = 0;	// 대각선(↙) 완성 개수
		
		for(int row = 0; row < btnOX.length; row++) {
			for(int col = 0; col <btnOX[row].length; col++) {
				// 가로검사
				if(btnOX[row][col] == true) {
					garoCount++;
					// 한줄이 모두 true이면 해당 줄의 5개의 버튼의 색을 변경한다.
						if(garoCount == SIZE) {
							for(int n = row * SIZE; n < row * SIZE + SIZE; n++) {
								btnArr[n].setBackground(Color.PINK);												
							}
						}
				}
				// 세로검사
				// row와 col순서를 뒤집으니 세로로 인식됨
				if(btnOX[col][row] == true) {	
					seroCount++;
					if(seroCount == SIZE) {
							// 5씩 증가시키면서 색을 변경
						for(int n = row; n < btnArr.length; n+=5) {
							btnArr[n].setBackground(Color.PINK);												
						}
					}
				}
				// 대각선(↘)검사
				if(row == col) {
					if(btnOX[row][col] == true)
					crossCount1++;
					if(crossCount1 == SIZE) {
						// 0에서 6씩 증가
						for(int n = 0; n < btnArr.length; n+=6) {
							btnArr[n].setBackground(Color.PINK);												
						}
						/*for(int n = 0; n < SIZE; n++) {
							btnArr[SIZE * n + n].setBackground(Color.GRAY);
						}*/
					}
				}
				// 대각선(↙)검사
				if(row + col == 4) {
					if(btnOX[row][col] == true)
					crossCount2++;
					if(crossCount2 == SIZE) {
						// 4에서 4씩증가, btnArr.length에서 1빼서 24제외
						for(int n = 4; n < btnArr.length - 1; n+=4) {	
							btnArr[n].setBackground(Color.PINK);												
						}
					}
				}
				
			}	//검사가 한줄 끝남
			if(garoCount == SIZE) bingoCount++;	// 한 줄에 5개가 true이면 한줄 완성
			
			if(seroCount == SIZE) bingoCount++;
			
			// 한줄에 대한 검사가 끝나면 garoCount와 seroCount를 0으로 초기화 한다.
			garoCount = 0;
			seroCount = 0;
		}
		// 대각선1과 대각선2는 오로지 1개씩만 존재하므로
		// 이중 for문이 끝난 곳에서 bingoCount를 증가시켜야한다.
		if(crossCount1 == SIZE) bingoCount++;
		if(crossCount2 == SIZE) bingoCount++;
		
		return bingoCount >= SIZE;
	}

	public static void main(String[] args) {
		new Bingo("빙고게임");
	}

}
