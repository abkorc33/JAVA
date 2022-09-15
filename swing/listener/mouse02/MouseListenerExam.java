package swing.listener.mouse02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MouseListenerExam extends JFrame{
	JLabel la;	// 라벨 생성
	
	MouseListenerExam() {
		setTitle("Mouse Event 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// x눌러서 닫기
		
		JPanel contentPane = new JPanel();	// 판넬 생성(기본이 투명임)
		setContentPane(contentPane);
		setLayout(null);	// 배치관리자 없애기
		
		contentPane.addMouseListener(new MyMouseListener());	// 마우스리스너 인스턴스 생성
		
		la = new JLabel("Hello");	// 라벨에 뭐라고 쓸지 작성
		la.setSize(50, 20);	// 라벨 사이즈
		la.setLocation(20, 20);
		contentPane.add(la);	// contentPane에 라벨 부착
		
		setSize(800, 600);
		setVisible(true);
	}
	class MyMouseListener extends MouseAdapter {	//필요한 부분만 구현 가능, 어댑터 클래스
		public void mousePressed(MouseEvent e) {	// 마우스 클릭
			int x = e.getX();
			int y = e.getY();	// 마우스 누른 곳의 좌표값을 가져온다.
			
			la.setLocation(x, y);	// 라벨을 이동시킨다.
		}
	}
	
	/*
	class MyMouseListener implements MouseListener {	//리스너 인터페이스
	// mousePressed만 기능을 사용하고싶은데 나머지 이벤트도 다 가져와서 구현해야됨
		public void mousePressed(MouseEvent e) {	// 마우스 클릭
			int x = e.getX();
			int y = e.getY();	// 마우스 누른 곳의 좌표값을 가져온다.
			
			la.setLocation(x, y);	// 라벨을 이동시킨다.
		}
		public void mouseReleased(MouseEvent e) {}
		public void mouseClicked(MouseEvent e) {}	// 마우스 한번, 두번 클릭 감지
		public void mouseEntered(MouseEvent e) {	// 마우스가 버튼에 올라갔을 때
			
		}
		public void mouseExited(MouseEvent e) {	// 마우스가 버튼에서 벗어났을 때
			
		}
	}*/

	public static void main(String[] args) {
		new MouseListenerExam();
	}

}
