package swing.listener.button01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ListenerExam extends JFrame{
	ListenerExam() {
		setTitle("Action Event Listener");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLayout(new FlowLayout());	
		// Container c = getContentPane(); 안하고 이렇게 써도 기본적으로 만들어짐
		
		JButton btn = new JButton("Action");
		// 이벤트 리스너를 등록한다.
		MyActionListener listener = new MyActionListener();	// Mouse Event Listener 객체를 생성한다.
		btn.addActionListener(listener);	// Mouse Event Listener 등록
		add(btn);	// 그냥 add하면 contentpane에 붙어있음
		
		setSize(300, 160);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListenerExam();

	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		
		if(btn.getText().equals("Action")) {
			btn.setText("액션");	// get으로 가져오고 set으로 값을 넣어서 바꿔준다.
		} else {
			btn.setText("Action");	//	react의 usestate 랑 비슷한듯
		}
		
	}
	
}
