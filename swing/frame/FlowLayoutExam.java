package swing.frame;

import java.awt.*;

import javax.swing.*;

public class FlowLayoutExam extends JFrame{
	
	FlowLayoutExam() {
		setTitle("FlowLayout 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 40)); // 배치관리자, 배치간격 조절 가능
		contentPane.add(new JButton("plus"));
		contentPane.add(new JButton("minus"));
		contentPane.add(new JButton("multiply"));
		contentPane.add(new JButton("divide"));
		contentPane.add(new JButton("Calculate"));
		
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new FlowLayoutExam();

	}

}
