package practice;

//2015112232�����
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class practice9 extends JFrame {

	practice9() {
		setTitle("���� ������");// ������ ����
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// ����� ���μ����� ����

		Container c = getContentPane();// pane����
		JPanel north = new JPanel(); // ������ �г� ����
		JPanel south = new JPanel();
		JPanel center = new JPanel();

		north.setBackground(Color.LIGHT_GRAY);// ���� ���߱�
		south.setBackground(Color.LIGHT_GRAY);
		center.setLayout(new GridLayout(5, 4));// gridlayout�������� ��ư ��ġ

		c.add(center, BorderLayout.CENTER); // pane�� ������ ��ġ�� �ֱ�
		c.add(north, BorderLayout.NORTH);
		c.add(south, BorderLayout.SOUTH);

		JLabel input1 = new JLabel("�����Է�"); // ���ڿ� �ؽ�Ʈ�ʵ� �߰�
		JTextField text1 = new JTextField(15);
		north.add(input1);
		north.add(text1);

		JLabel input2 = new JLabel("�����");// ���ڿ� �ؽ�Ʈ�ʵ� �߰�
		JTextField text2 = new JTextField(15);
		south.add(input2);
		south.add(text2);

		for (int i = 0; i < 20; i++) {// ������ ��ġ�� ���� �־��ֱ�
			JButton b = new JButton();
			String[] s = { "CE", "���", "����", "������", "������", "��������", "+", "-", "x", "/" };
			center.add(b);
			if (i < 10) {
				b.setText(i + "");
			} else {
				b.setText(s[i - 10]);
			}
			if (i > 15) {
				b.setOpaque(true);
				b.setBackground(Color.CYAN); // ���� ����
			}

		}
		setVisible(true);// ���̰� �����
	}

	public static void main(String[] args) {
		new practice9();// ����
	}
}
