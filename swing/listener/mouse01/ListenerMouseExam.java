package swing.listener.mouse01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerMouseExam extends JFrame{
	ListenerMouseExam() {
		setTitle("버튼에 마우스 이벤트 리스너를 작성해보자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Mouse Event Example Button");
		btn.setBackground(Color.ORANGE);
		
		MyMouseListener listener = new MyMouseListener();	// 리스너 인스턴스 생성
		btn.addMouseListener(listener);	// 버튼에 리스너 등록
		add(btn);	// 버튼생성
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerMouseExam();
	}

}

class MyMouseListener implements MouseListener {
	public void mouseEntered(MouseEvent e) {	// 마우스가 버튼에 올라갔을 때
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.RED);
	}
	public void mouseExited(MouseEvent e) {	// 마우스가 버튼에서 벗어났을 때
		JButton btn = (JButton)e.getSource();
		btn.setBackground(Color.ORANGE);
	}
	public void mousePressed(MouseEvent e) {}	// 마우스 우클릭
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {}	// 마우스 한번, 두번 클릭 감지
}
