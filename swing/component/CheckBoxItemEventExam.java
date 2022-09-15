package swing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CheckBoxItemEventExam extends JFrame{
	JCheckBox[] fruits = new JCheckBox[3];
	String[] names = {"사과", "배", "바나나"};
	JLabel sumLabel;
	
	CheckBoxItemEventExam() {
		setTitle("체크박스와 아이템이벤트 연습하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.setBackground(Color.ORANGE);
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과: 1000원 배: 2000원 바나나: 3000원"));
		
		MyItemListener listener = new MyItemListener();	// 생성 해줘야 쓸 수 있음
		
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);	// 체크박스 마다 구현해주기 위해 반복문 안에 넣음
		}
		
		sumLabel = new JLabel("현재 0원 입니다.");
		c.add(sumLabel);
		
		setSize(400, 300);
		setVisible(true);
	}
	// 아이템리스너 구현
	class MyItemListener implements ItemListener {
		int sum = 0;	// 선택된 과일들의 합계 금액
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			if(e.getStateChange() == ItemEvent.SELECTED) {	// 체크가 된 상태
				if(e.getItem() == fruits[0]) sum += 1000;	// 선택된 게 무엇인지 감지할 수 있는 메서드
				else if(e.getItem() == fruits[1]) sum += 2000;
				else sum += 3000;
			}else {	// 체크 해제 상태
				if(e.getItem() == fruits[0]) sum -= 1000;
				else if(e.getItem() == fruits[1]) sum -= 2000;
				else sum -= 3000;
			}
			sumLabel.setText("현재 " + sum + "원 입니다");// label에 글 쓸때 .setText
			
		}
		
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventExam();

	}

}
