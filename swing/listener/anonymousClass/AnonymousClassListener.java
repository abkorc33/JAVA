package swing.listener.anonymousClass;	// 익명클래스
//클래스조차 만들 필요없이 리스너 코드가 간단한 경우에 적합.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousClassListener extends JFrame{
	AnonymousClassListener() {
		setTitle("버튼에 마우스 이벤트 리스너를 작성해보자");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		// 익명의 클래스로 이벤트 리스너를 작성한다.
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton btn = (JButton)e.getSource();
				
				if(btn.getText().equals("Action")) {
					btn.setText("액션");	// get으로 가져오고 set으로 값을 넣어서 바꿔준다.
				} else {
					btn.setText("Action");
				}
				
			}
		});	
		add(btn);	// 그냥 add하면 contentpane에 붙어있음
		
		setSize(300, 160);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new AnonymousClassListener();

	}

}

