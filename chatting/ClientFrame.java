package chatting;

import javax.swing.*;
import java.awt.event.*;
import java.net.Socket;
import java.awt.*;

// 로그인 화면 : 닉네임을 입력하고 입장하는 화면
class Id extends JFrame implements ActionListener {
	
	static JTextField tf = new JTextField(8);	// 8자, 텍스트 입력 창
	JButton btn = new JButton("입장");
	
	WriteClass wc;
	ClientFrame cf;
	
	// 기본 생성자
	public Id() {}
	
	// 매개변수 있는 생성자
	public Id(WriteClass wc, ClientFrame cf) {
		super("아이디");
		this.wc = wc;
		this.cf = cf;
		
		setLayout(new FlowLayout());
		add(new JLabel("아이디"));
		add(tf);
		add(btn);
		
		btn.addActionListener(this);
		
		setBounds(400, 300, 250, 100);
		setVisible(true);
	}
	// 아이디를 입력하고 입장버튼을 눌렀을 경우 작동하는 메서드
	public void actionPerformed(ActionEvent e) {
		
		wc.sendMsg();	// 처음 입장을 알리는 메시지를 전송한다.
		cf.isFirst = false;	// 입장이 되었으므로, isFirst를 false로 바꾼다.
		cf.setVisible(true);	// 채팅창을 화면에 보여준다.
		this.dispose();	// 로그인 창(자신)은 사라진다.
		
	}
	
	// 아이디를 알아내는 메서드
	static public String getId() {
		return tf.getText();
	}
	
}

// 채팅창 클래스
public class ClientFrame extends JFrame implements ActionListener {
	JTextArea txtA = new JTextArea();
	JTextField txtF = new JTextField(15);
	JButton btnTransfer = new JButton("전송");
	JButton btnExit = new JButton("닫기");
	
	boolean isFirst = true;	// 바로 입장을 한 상태인지, 대화 중인지의 상태를 나타낸다.
	
	JPanel p1 = new JPanel();
	
	Socket socket;
	WriteClass wc;
	
	// 생성자
	public ClientFrame(Socket socket) {
		super("채팅");
		this.socket = socket;
		wc = new WriteClass(this);
		new Id(wc, this);
		
		txtA.setFont(new Font("굴림", Font.ITALIC+Font.BOLD, 24));
		txtA.setBackground(Color.YELLOW);
		add("Center", txtA);
		
		p1.add(txtF);	// 메세지 입력란
		p1.add(btnTransfer);	// 전송버튼
		p1.add(btnExit);	// 닫기버튼
		add("South",p1);
		
		// 버튼들에 리스너를 장착시킨다.
		btnTransfer.addActionListener(this);// 같은 클래스면 this사용 가능
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setBounds(300, 300, 500, 500);
		setVisible(false);	// 로그인 창을 먼저 보여주기 위해서 대화창을 숨긴다.
		
	}
	
	// 전송버튼을 눌렀을 경우 실행하는 메서드
	public void actionPerformed(ActionEvent e) {
		String id = Id.getId();
		
		if(e.getSource() == btnTransfer) {
			// 메세지를 입력하지 않고 전송버튼만 눌렀을 경우는 화면으로 돌아가게 한다.
			if(txtF.getText().equals("")) {
				return;
			}
			
			txtA.append("[" + id + "] " + txtF.getText() + "\n");	// append는 붙이는것 
			wc.sendMsg();
			txtF.setText("");	// 메세지를 전송했으므로 메세지 입력란을 지워준다.
		} else {	// 닫기 버튼을 눌렀을 경우
			this.dispose();
		}
	}
}



