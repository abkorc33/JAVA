package swing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonExam extends JFrame{
	RadioButtonExam() {
		setTitle("라디오버튼 만들기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();	// 하나만 선택할 수 있게 하려면 그룹으로 묶어야 한다.
		
		JRadioButton apple = new JRadioButton("사과", true);	// 창이 뜰 때 기본으로 선택됨
		JRadioButton pear = new JRadioButton("배");
		JRadioButton banana = new JRadioButton("바나나");
		
		// 버튼 그룹에 3개의 라디오 버튼을 추가한다.
		g.add(apple);	g.add(pear);	g.add(banana);
		
		c.add(apple);	c.add(pear);	c.add(banana);
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new RadioButtonExam();
	}

}
