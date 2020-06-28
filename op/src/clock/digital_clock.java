package clock;

//2015112232�����

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Graphics;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class digital_clock extends JFrame {

	public digital_clock() {
		setTitle("������ �ð�");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.add(new MyPanel());

		setSize(600, 200);
		setVisible(true);
	}

	class MyPanel extends JPanel implements Runnable {
		Calendar cal;
		
		public MyPanel() {
			Thread t = new Thread(this);
			t.start();//������ ����
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			cal = Calendar.getInstance();
			int sec = cal.get(Calendar.SECOND); // �� ����
			int min = cal.get(Calendar.MINUTE); // �� ����
			int hour = cal.get(Calendar.HOUR); // �� ����
			
			//�ð�
			drawsegment(g, hour/10, 0);
			drawsegment(g, hour%10, 7);
			//��
			drawsegment(g, min/10, 18);
			drawsegment(g, min%10, 25);
			//��	
			drawsegment(g, sec/10, 36);
			drawsegment(g, sec%10, 43);

			
		}

		public void drawsegment(Graphics g, int n, int x) {
			g.fillOval(170, 50, 10, 10); //�߰� ����
			g.fillOval(170, 100, 10, 10); 
			g.fillOval(350, 50, 10, 10); //�߰� ����
			g.fillOval(350, 100, 10, 10); 
			
			switch (n) {
			//������ ���ڿ� ���� segment
			case 0:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 70, 10, 60); // E
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				break;
			case 1:
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				break;
			case 2:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 70, 10, 60); // E
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			case 3:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			case 4:
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			case 5:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			case 6:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 70, 10, 60); // E
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				g.fillOval(10 * x + 20, 70, 60, 10); // G

				break;
			case 7:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				break;
			case 8:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 70, 10, 60); // E
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			case 9:
				g.fillOval(10 * x + 20, 20, 60, 10); // A
				g.fillOval(10 * x + 70, 20, 10, 60); // B
				g.fillOval(10 * x + 70, 70, 10, 60); // C
				g.fillOval(10 * x + 20, 120, 60, 10); // D
				g.fillOval(10 * x + 20, 20, 10, 60); // F
				g.fillOval(10 * x + 20, 70, 60, 10); // G
				break;
			}
		}

		public void run() {
			try {
				while (true) {//1�� ������ �ٽ� �׸�
					Thread.sleep(1000);
					repaint();
				}
			} catch (Exception e) {
			}
		}

	}

	public static void main(String[] args) {
		new digital_clock();
	}

}
