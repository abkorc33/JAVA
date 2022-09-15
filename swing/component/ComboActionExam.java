package swing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ComboActionExam extends JFrame{
	String[] fruits = {"apple", "banana", "kiwi", "mango"};
	ImageIcon[] images = {
			new ImageIcon("src/swing/image/apple.jpg"),
			new ImageIcon("src/swing/image/banana.jpg"),
			new ImageIcon("src/swing/image/kiwi.jpg"),
			new ImageIcon("src/swing/image/mango.jpg"),
	};
	JLabel imgLabel = new JLabel(images[0]);
	
	ComboActionExam() {
		setTitle("콤보박스 활용하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JComboBox combo = new JComboBox(fruits);
		c.add(combo);
		c.add(imgLabel);
		
		// 콤보박스에 Action Listener를 등록한다.
		// 선택한 아이템에 관련된 이미지를 출력한다.
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();	// 눌린 스위치가 어떤것인지 감지
				int index = cb.getSelectedIndex();	// 인덱스 감지
				imgLabel.setIcon(images[index]);
			}
			
		});
		
		setSize(360, 280);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ComboActionExam();

	}

}
