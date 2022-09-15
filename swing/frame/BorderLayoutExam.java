package swing.frame;

import java.awt.*;

import javax.swing.*;

public class BorderLayoutExam extends JFrame{
	BorderLayoutExam() {
		
		setTitle("BorderLayoutExam 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane();
		
		contentPane.setLayout(new BorderLayout(30, 20));
		contentPane.add(new JButton("Calcultate"), BorderLayout.CENTER);
		contentPane.add(new JButton("add"), BorderLayout.NORTH);
		contentPane.add(new JButton("sub"), BorderLayout.SOUTH);
		contentPane.add(new JButton("mul"), BorderLayout.EAST);
		contentPane.add(new JButton("div"), BorderLayout.WEST);
		
		setSize(400, 300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new BorderLayoutExam();

	}

}
