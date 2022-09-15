package swing.component;

import javax.swing.*;
import java.awt.*;

public class CheckBoxExam extends JFrame{
	CheckBoxExam() {
		setTitle("체크박스만들기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox banana = new JCheckBox("바나나");
		JCheckBox pear = new JCheckBox("배");
		
		c.add(apple);	c.add(banana);	c.add(pear);
		
		setSize(280, 180);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CheckBoxExam();

	}

}
