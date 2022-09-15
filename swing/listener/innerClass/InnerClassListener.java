package swing.listener.innerClass;	// 내부에 private 클래스
//이벤트 리스너를 특정 클래스에서만 사용할 때 적합.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame{
	InnerClassListener() {
		setTitle("버튼에 마우스 이벤트 리스너를 작성해보자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		// 이벤트 리스너를 등록한다.
		MyActionListener listener = new MyActionListener();	// Mouse Event Listener 객체를 생성한다.
		btn.addActionListener(listener);	// Mouse Event Listener 등록
		add(btn);	// 그냥 add하면 contentpane에 붙어있음
		
		setSize(300, 160);
		setVisible(true);
	}
	// private으로 선언하여 InnerClassListener의 외부에서는 사용할 수 없게 했다.
	private class MyActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			if(btn.getText().equals("Action")) {
				btn.setText("액션");	// get으로 가져오고 set으로 값을 넣어서 바꿔준다.
			} else {
				btn.setText("Action");
			}
			
		}
		
	}
	public static void main(String[] args) {
		new InnerClassListener();

	}

}

