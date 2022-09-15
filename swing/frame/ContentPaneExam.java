package swing.frame;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ContentPaneExam extends JFrame{
	
	ContentPaneExam() {
		setTitle("ContentPane과 JFrame 공부하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 우측 상단의 x버튼을 활성화시킨다.
		//메모리에서 없애주는 역할
		
		Container contentPane = getContentPane();	// 컨텐트팬의 정보를 알아내기
		contentPane.setBackground(Color.ORANGE);	// 배경바꾸기
		contentPane.setLayout(new FlowLayout());	// 컨텐트팬에 배치관리자를 설정한다.
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(500, 400);	// width, height
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneExam();

	}

}
