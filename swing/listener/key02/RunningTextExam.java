package swing.listener.key02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunningTextExam extends JFrame{
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("Hello");
	final int RUNNING_UNIT = 10;
	
	RunningTextExam() {
		setTitle("방향키를 이용하여 글자 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);	// 임의로 움직여야하기 때문에 레이아웃 해제
		contentPane.addKeyListener(new MyKeyListener());
		
		la.setLocation(50, 50);
		la.setSize(30, 20);
		
		la.setOpaque(true);
		la.setBackground(Color.ORANGE);
		contentPane.add(la);
		
		setSize(800, 600);
		setVisible(true);
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			
			//System.out.println(la.getWidth() + ":" + la.getHeight());
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				if(la.getY() < 10 || la.getY() > 530) {
					la.setLocation(la.getX(), 530);
				}else {
					la.setLocation(la.getX(), la.getY() - RUNNING_UNIT);										
				}
				break;
			case KeyEvent.VK_DOWN:
				if(la.getY() < 0 || la.getY() > 530) {
					la.setLocation(la.getX(), 0);
				}else {
					la.setLocation(la.getX(), la.getY() + RUNNING_UNIT);										
				}
				break;
			case KeyEvent.VK_LEFT:
				if(la.getX() < 10 || la.getX() > 740) {
					la.setLocation(740, la.getY());
				}else {					
					la.setLocation(la.getX() - RUNNING_UNIT, la.getY());
				}
				break;
			case KeyEvent.VK_RIGHT:
				if(la.getX() < 0 || la.getX() > 740) {
					la.setLocation(0, la.getY());
				}else {					
					la.setLocation(la.getX() + RUNNING_UNIT, la.getY());
				}
				break;
			}
		}
	}

	public static void main(String[] args) {
		new RunningTextExam();

	}

}
