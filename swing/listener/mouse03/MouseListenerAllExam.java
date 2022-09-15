package swing.listener.mouse03;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerAllExam extends JFrame{
	JPanel contentPane = new JPanel();
	JLabel la;
	
	MouseListenerAllExam() {
		setTitle("마우스 리스너와 마우스 모션리스너 공부");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(contentPane);
		
		contentPane.addMouseListener(new MyMotionListener());
		contentPane.addMouseMotionListener(new MyMotionListener());
		
		la = new JLabel("No Motion Event");
		contentPane.add(la);
		setSize(600, 400);
		setVisible(true);
	}
	class MyMotionListener implements MouseListener, MouseMotionListener {
		public void mousePressed(MouseEvent e) {
			la.setText("MousePressed(" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseReleased(MouseEvent e) {
			la.setText("MouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseClicked(MouseEvent e) {}
		public void mouseEntered(MouseEvent e) {
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.MAGENTA);
		}
		public void mouseExited(MouseEvent e) {
			JPanel p = (JPanel)e.getSource();
			p.setBackground(Color.YELLOW);
		}
		public void mouseDragged(MouseEvent e) {
			la.setText("MouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}
		public void mouseMoved(MouseEvent e) {
			la.setText("MouseMoved(" + e.getX() + ", " + e.getY() + ")");
		}
	}

	public static void main(String[] args) {
		new MouseListenerAllExam();

	}

}
