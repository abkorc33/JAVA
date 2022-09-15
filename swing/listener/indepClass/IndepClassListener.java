package swing.listener.indepClass;	// 독립된 클래스, 외부에 클래스를 생성하여 다른 클래스에서도 사용
// 이벤트 리스너를 여러 곳에서 사용할 때 적합.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class IndepClassListener extends JFrame{
	IndepClassListener() {
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
	public static void main(String[] args) {
		new IndepClassListener();

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
