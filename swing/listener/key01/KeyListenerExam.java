package swing.listener.key01;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyListenerExam extends JFrame {
	JPanel contentPane = new JPanel();
	JLabel[] keyMessage;
	
	KeyListenerExam() {
		setTitle("KeyListener Examle");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.addKeyListener(new MyKeyListener());
		
		keyMessage = new JLabel[3];
		keyMessage[0] = new JLabel("getKeyCode() ");
		keyMessage[1] = new JLabel("getKeyChar() ");
		keyMessage[2] = new JLabel("getKeyText() ");
		
		for(int i = 0; i < keyMessage.length; i++) {
			contentPane.add(keyMessage[i]);
			keyMessage[i].setOpaque(true);  // Opaque의 값을 미리 true로 설정해 주어야 배경색이 적용된다.
			keyMessage[i].setBackground(Color.CYAN);
		}
		
		setSize(300, 150);
		setVisible(true);
		contentPane.requestFocus();// 판넬에 포커스가 있게 만들어줌
	}
	
	class MyKeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			char keyChar = e.getKeyChar();
			keyMessage[0].setText(Integer.toString(keyCode));
			keyMessage[1].setText(Character.toString(keyChar));
			keyMessage[2].setText(e.getKeyText(keyCode));
		}
	}

	public static void main(String[] args) {
		new KeyListenerExam();

	}

}
