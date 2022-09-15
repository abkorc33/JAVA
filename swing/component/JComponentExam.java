package swing.component;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentExam extends JFrame{
	JComponentExam() {
		super("JComponent의 공통 메서드 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setLayout(new FlowLayout());	// 배치관리자
		
		JButton b1 = new JButton("Magenta/Yellow Button");
		JButton b2 = new JButton("Disabled Button");
		JButton b3 = new JButton("getX(), getY()");
		
		b1.setBackground(Color.YELLOW);
		b1.setForeground(Color.MAGENTA);
		b1.setFont(new Font("ARIAL", Font.ITALIC, 20));
		
		b2.setEnabled(false);
		
		b3.addActionListener(new ActionListener() {	// 이벤트리스너 기능, 감지

			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();	// 컴포넌트의 진원지를 알 수 있음
				setTitle(b.getX() + ", " + b.getY());
				}
			
		});
		
		c.add(b1); c.add(b2); c.add(b3);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JComponentExam();

	}

}
