package swing.frame;

import java.awt.*;

import javax.swing.*;

public class NoneLayoutExam extends JFrame{
	NoneLayoutExam() {
		super("배치관리자 없이 절대 위치에 버튼을 배치하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		contentPane.setLayout(null);	// 컨텐트팬의 배치관리자를 제거한다.
		
		JLabel la = new JLabel("How are you?");
		la.setLocation(260, 80);
		la.setSize(200, 30);	// 폭, 높이
		contentPane.add(la);
		
		// 버튼을 9개 생성하고 사선방향으로 살짝 겹치게 배열해보자
		for(int i = 1; i <= 9; i++) {
			JButton bt = new JButton(Integer.toString(i));
			bt.setLocation(i*15, i*15);
			bt.setSize(50, 20);
			contentPane.add(bt);
			}
		
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new NoneLayoutExam();

	}

}
