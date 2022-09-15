package swing.listener.key02;	// 남는 공간 없이 창 크기에 맞게 이동

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RunningTextExam2 extends JFrame{
	JPanel contentPane = new JPanel();
	JLabel la = new JLabel("Hello");
	final int RUNNING_UNIT = 10;
	
	RunningTextExam2() {
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
		contentPane.setFocusable(true); // 컴포넌트가 포커스를 받을 수 있도록 설정한다.
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		
		public void keyPressed(KeyEvent e) {	// 방향키를 눌렀을 경우 처리해야 하는 이벤트
			int keyCode = e.getKeyCode();
			
			// 실제 라벨이 움직일 수 있는 공간 == Insets 부분을 뺀 공간
			int runWidth = contentPane.getWidth() - la.getWidth();
			int runHeight = contentPane.getHeight() - la.getHeight();
			
			switch(keyCode) {
			case KeyEvent.VK_UP:
				if(la.getY() > 0) {
					if(la.getY() >= RUNNING_UNIT)	// RUNNING_UNIT 만큼 움직일 수 있는 공간이 있는경우
						la.setLocation(la.getX(), la.getY() - RUNNING_UNIT);										
				else 
					la.setLocation(la.getX(), 0);	// 짜투리 공간
				}
				getPosition();
				break;
			case KeyEvent.VK_DOWN:
				if(la.getY() < runHeight) {
					if(runHeight - la.getY() < RUNNING_UNIT)// 짜투리공간
						la.setLocation(la.getX(), la.getY() + (runHeight - la.getY()));	
					else 
						la.setLocation(la.getX(), la.getY() + RUNNING_UNIT);										
				}
				getPosition();
				break;
			case KeyEvent.VK_LEFT:
				if(la.getX() > 0) {
					if(la.getX() >= RUNNING_UNIT)
						la.setLocation(la.getX() - RUNNING_UNIT, la.getY());
				else 				
					la.setLocation(0, la.getY());
				}
				getPosition();
				break;
			case KeyEvent.VK_RIGHT:
				if(la.getX() < runWidth) {
					if(runWidth - la.getX() < RUNNING_UNIT)
						la.setLocation(la.getX() + (runWidth - la.getX()), la.getY());
					else 				
						la.setLocation(la.getX() + RUNNING_UNIT, la.getY());
				}
				getPosition();
				break;
			}
		}
		//방향키를 누른 후의 좌표값을 알려주는 메서드
		void getPosition() {
			System.out.println(la.getX() + ", " +la.getY());	//라벨의 현재 위치
		}
	}

	public static void main(String[] args) {
		new RunningTextExam2();

	}

}
