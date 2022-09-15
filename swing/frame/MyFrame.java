package swing.frame;	// 추상 메서드

import javax.swing.JFrame;

public class MyFrame extends JFrame{
	
	MyFrame() {	// 위치 지정안하면 0,0 좌표에 나옴
		setTitle("나의 첫번째 프레임");	// 프레임 맨 위 창의 제목
		setSize(300, 400);	// 사이즈 지정
		setVisible(true);	// 참으로 해줘야 눈에 보임
	}

	public static void main(String[] args) {
		MyFrame mf = new MyFrame();

	}

}
