package swing.listener.mouse04;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickAndDoubleClickExam extends JFrame {
	JPanel contentPane = new JPanel();
	
	ClickAndDoubleClickExam() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		contentPane.addMouseListener(new MyMouseListener());
		setSize(600, 400);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter {
		
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 2);	{	// 클릭 횟수 감지, 더블클릭 시	
				int r = (int)(Math.random() * 256);
				int g = (int)(Math.random() * 256);
				int b = (int)(Math.random() * 256);
				
				JPanel p = (JPanel)e.getSource();
				p.setBackground(new Color(r, g, b));
				setTitle(r + ", " + g + ", " + b);
			}
		}
	}
	
	public static void main(String[] args) {
		new ClickAndDoubleClickExam();

	}

}

