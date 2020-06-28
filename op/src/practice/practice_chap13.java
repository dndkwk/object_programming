package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class practice_chap13 extends JFrame {
	public practice_chap13() {

		super("�����带 ���� �׺�");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		Container c = getContentPane();
		c.setLayout(null); // null ����

		setSize(300, 200);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		JLabel[] la = new JLabel[3];
		JLabel s = new JLabel("���콺�� Ŭ���� �� ���� �����մϴ�.");
		GamblingThread GT = new GamblingThread(la, s);

		MyPanel() {

			for (int i = 0; i < 3; i++) {
				la[i] = new JLabel("0");
				la[i].setSize(30, 30);
				la[i].setLocation(60 + 80 * i, 50); // ��ġ
				la[i].setOpaque(true);
				la[i].setBackground(Color.MAGENTA); // ��� ��
				la[i].setForeground(Color.YELLOW); // ���� ��
				la[i].setFont(new Font("�ü�", Font.ITALIC, 30)); // ���� ũ��
				la[i].setHorizontalAlignment(JLabel.CENTER); // ���� ����
				add(la[i]);
			}
			s.setSize(220, 30);
			s.setLocation(30, 100);
			s.setHorizontalAlignment(JLabel.CENTER); // ���� ����
			add(s);
			GT.start();
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!GT.getgambling()) { // ���� �ȉ������� ����
						GT.startGambling();
					}
				}
			});
		}

	}

	class GamblingThread extends Thread {
		boolean gambling = false; // �������� �۵� ���� ����. �ʱⰪ = false
		long delay = 200;
		JLabel[] number = new JLabel[3]; // ���� ���̺�
		JLabel s; // ��� �˷��ִ� ���̺�

		GamblingThread(JLabel[] number, JLabel s) {
			this.number = number;
			this.s = s;
		}

		boolean getgambling() {
			return gambling;
		}

		synchronized public void waitForGambling() { // �������� run()���� ȣ��
			if (!gambling) { // ���콺 Ŭ���� ���� gambling�� true�� �� ������ ��ٸ�
				try {
					this.wait();
				} catch (InterruptedException e) {
					return;
				}
			}
		}

		synchronized public void startGambling() { // ���콺 Ŭ�� �ڵ鷯���� ȣ��
			gambling = true; // ���콺 Ŭ������ �����尡 ������ �����ϵ��� ����
			this.notify(); // ��ٸ��� �����带 ����
		}

		public void run() {
			while (true) {
				waitForGambling(); // ���콺 Ŭ���� �Ͼ�⸦ ��ٸ���.
				try {
					s.setText(null);
					int a = (int) (Math.random() * 5);
					int b = (int) (Math.random() * 5);
					int c = (int) (Math.random() * 5);

					number[0].setText(Integer.toString(a)); // �󺧿� ���� �ֱ�
					sleep(delay);// 200ms �������� 3�� sleep()�� �ϸ鼭 ���ڸ� ����Ѵ�.
					number[1].setText(Integer.toString(b));
					sleep(delay);
					number[2].setText(Integer.toString(c));
					sleep(delay);

					if ((a == b) && (b == c)) {// ������ �����Ͽ����� �Ǻ��Ͽ� �޽����� ����Ѵ�.
						s.setText("�����մϴ�!!");
					} else {
						s.setText("�ƽ�����");
					}

				} catch (InterruptedException e) {
					return;
				}
				gambling = false;// ���� ���� ������ �����ϵ��� �����Ѵ�.
			}
		}
	}

	
	public static void main(String[] args) {
		new practice_chap13();
	}

}
