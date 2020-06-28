package practice;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class KeyPlusMinusFrame extends JFrame {
	public KeyPlusMinusFrame() {
		super("+,- Ű�� ��Ʈ ũ�� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���μ������� ���� ����
		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		JLabel label = new JLabel("Love Java"); // �� �̸�
		c.add(label);

		label.setFont(new Font("TimesRoman", Font.PLAIN, 14)); // �⺻ 14 ũ��
		label.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyChar() == '+') { // + Ű�� ������ ��
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize();
					if (size >= 24) { // �ִ� 24
						return;
					}
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 5));// 5�� ����

					if ((size + 5) == 24) { // ���� �ٲٱ�
						c.setBackground(Color.CYAN); // �ִ��϶�
					} else if ((size + 5) == 8) { // �ּ��϶�
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}

				} else if (e.getKeyChar() == '-') { // - Ű�� ������ ��
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // �ּ� 8
					if (size <= 8)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 5));// 5�� ����

					if ((size - 5) == 24) { // ���� �ٲٱ�
						c.setBackground(Color.CYAN); // �ִ��϶�
					} else if ((size - 5) == 8) { // �ּ��϶�
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}

				} else if (e.getKeyCode() == KeyEvent.VK_UP) {// �� ����Ű ��������
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // �ִ� 24
					if (size >= 24) {
						return;
					}
					la.setFont(new Font("TimesRoman", Font.PLAIN, size + 1)); // 1�� ����

					if ((size + 1) == 24) { // ���� �ٲٱ�
						c.setBackground(Color.CYAN); // �ִ��϶�
					} else if ((size + 1) == 8) { // �ּ��϶�
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}
				} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {// �Ʒ� ����Ű ��������
					JLabel la = (JLabel) e.getSource();
					Font f = la.getFont();
					int size = f.getSize(); // �ּ�8
					if (size <= 8)
						return;
					la.setFont(new Font("TimesRoman", Font.PLAIN, size - 1)); // 1�� ����

					if ((size - 1) == 24) { // ���� �ٲٱ�
						c.setBackground(Color.CYAN);// �ִ��϶�
					} else if ((size - 1) == 8) {// �ּ��϶�
						c.setBackground(Color.YELLOW);
					} else {
						c.setBackground(null);
					}
				}
			}
		});

		setSize(300, 150);
		setVisible(true);

		label.setFocusable(true); // ���̺��� ��Ŀ���� ���� �� �ֵ��� ����
		label.requestFocus(); // ���̺� Ű �Է� ��Ŀ�� ����
	}

	public static void main(String[] args) {
		new KeyPlusMinusFrame(); //����
	}

}
