package swing.component;

import java.awt.*;

import javax.swing.*;

public class ButtonImageExam extends JFrame {
	ButtonImageExam() {
		setTitle("이미지 버튼 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("src/swing/image/normalIcon.gif");
		ImageIcon pressedIcon = new ImageIcon("src/swing/image/pressedIcon.gif");
		ImageIcon rolloverIcon = new ImageIcon("src/swing/image/rolloverIcon.gif");
		
		JButton btn = new JButton("call", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		c.add(btn);
		setSize(250, 160);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ButtonImageExam();

	}

}
