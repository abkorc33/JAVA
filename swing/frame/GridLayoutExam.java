package swing.frame;
import java.awt.*;

import javax.swing.*;

public class GridLayoutExam extends JFrame {
	public GridLayoutExam() {
		super("GridLayout 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		// 1x10의 GridLayout 배치관리자를 설정한다.
		contentPane.setLayout(new GridLayout(1, 10));// (1행 10열)
		
		for(int i = 0; i < 10; i++) {	// 10개의 버튼을 부착시킨다.
			String text = Integer.toString(i+1);
			JButton button = new JButton(text);
			contentPane.add(button);
		}
		
		setSize(500, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new GridLayoutExam();

	}

}
