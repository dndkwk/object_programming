package practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPlusMinusFrame extends JFrame {
	public KeyPlusMinusFrame() {
		super("+,- 키로 폰트 크기 조절");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프로세스까지 같이 종료
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label = new JLabel("Love Java"); // 라벨 이름
		c.add(label);

		label.setFont(new Font("TimesRoman", Font.PLAIN, 14)); // 기본 14 크기
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '+') { // + 키를 눌렀을 때
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if (size >= 24) { // 최대 24
						return;
					}
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));// 5씩 증가

					if ((size + 5) == 24) { // 배경색 바꾸기
						c.setBackground(Color.CYAN); // 최대일때
					} else if ((size + 5) == 8) { // 최소일때
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}

				} else if (e.getKeyChar() == '-') { // - 키를 눌럿을 때
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // 최소 8
					if (size <= 8)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));// 5씩 감소

					if ((size - 5) == 24) { // 배경색 바꾸기
						c.setBackground(Color.CYAN); // 최대일때
					} else if ((size - 5) == 8) { // 최소일때
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {// 위 방향키 눌렀을때
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // 최대 24
					if (size >= 24) {
						return;
					}
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 1)); // 1씩 증가

					if ((size + 1) == 24) { // 배경색 바꾸기
						c.setBackground(Color.CYAN); // 최대일때
					} else if ((size + 1) == 8) { // 최소일때
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {// 아래 방향키 눌렀을때
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // 최소8
					if (size <= 8)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 1)); // 1씩 감소

					if ((size - 1) == 24) { // 배경색 바꾸기
						c.setBackground(Color.CYAN);// 최대일때
					} else if ((size - 1) == 8) {// 최소일때
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}
				}
			}
		});

		setSize(300, 150);
		setVisible(true);

		label.setFocusable(true); // 레이블이 포커스를 받을 수 있도록 지정
		label.requestFocus(); // 레이블에 키 입력 포커스 서정
	}

	public static void main(String[] args) {
		new KeyPlusMinusFrame(); //실행
	}

}
