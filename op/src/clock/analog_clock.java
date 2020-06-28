package clock;

//2015112232�����
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class analog_clock extends JFrame {

	private Image img;
	private Graphics img_graphic;
	private final int WIDTH = 600;
	private final int HEIGHT = 600;

	public analog_clock() {
		setTitle("analog clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		c.add(new MyPanel(), BorderLayout.CENTER);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}

	class MyPanel extends JPanel implements Runnable {
		int x, y, r;
		Calendar cal;

		public MyPanel() {
			x = 300;// �߽�
			y = 300;
			r = 200; // ������
			Thread t = new Thread(this);
			t.start();
		}

		public void paintComponent(Graphics g) {
			img = createImage(WIDTH, HEIGHT);//������۸�
	        img_graphic = img.getGraphics();
	        paintComponents(img_graphic);
	        
			cal = Calendar.getInstance();
			int sec = cal.get(Calendar.SECOND); // ��
			int min = cal.get(Calendar.MINUTE); // ��
			int hour = cal.get(Calendar.HOUR); // ��

			// �ð� �׵θ�
			g.setColor(Color.BLACK);
			g.fillOval(100, 100, 400, 400);// �ð� �׵θ� ũ��
			g.setColor(Color.WHITE);
			for (int i = 0; i <= 360; i += 6) { // �ð� �� ǥ��
				int x1 = (int) (r * Math.sin(3.14 * i / 180) + x);
				int y1 = (int) (r * Math.cos(3.14 * i / 180) + y);
				int x2 = (int) ((r - 5) * Math.sin(3.14 * i / 180) + x);
				int y2 = (int) ((r - 5) * Math.cos(3.14 * i / 180) + y);

				if (i % 30 == 0) { // ū ���� ǥ��
					int j = 1;
					x2 = (int) ((r - 20) * Math.sin(3.14 * i / 180) + x);
					y2 = (int) ((r - 20) * Math.cos(3.14 * i / 180) + y);
				}
				g.drawLine(x1, y1, x2, y2);// �� �׸���

			}

			if (sec == 60) {// �� ����
				sec = 0;
				min++;
			}
			if (min == 60) {// �� ����
				min = 0;
				hour++;
			}
			if (min == 60 && hour == 12) {
				hour = 0;
			}

			sec = sec * 6 - 90;// 12�ú��� ���ư��Ƿ� 90���� ���ش�
			int xS = (int) (r * Math.cos(3.14 * sec / 180) + x);// sin,cos���̿��Ͽ� ��ġ���ϱ�
			int yS = (int) (r * Math.sin(3.14 * sec / 180) + y);
			g.setColor(Color.WHITE);
			g.drawLine(x, y, xS, yS);

			min = cal.get(Calendar.MINUTE) * 6 + sec / 60 - 90;
			int xM = (int) (150 * Math.cos(3.14 * min / 180) + x);
			int yM = (int) (150 * Math.sin(3.14 * min / 180) + y);
			g.setColor(Color.WHITE);
			g.drawLine(x, y, xM, yM);

			hour = hour * 30 + cal.get(Calendar.MINUTE) / 2 - 90;
			int xH = (int) (100 * Math.cos(3.14 * hour / 180) + x);
			int yH = (int) (100 * Math.sin(3.14 * hour / 180) + y);
			g.setColor(Color.WHITE);
			g.drawLine(x, y, xH, yH);
			
			
			g.drawImage(img, 0, 0, null);
			repaint();
		}

		public void run() {
			try {
				while (true) {// 1�� ������ �ٽñ׸�
					Thread.sleep(1000);
//					repaint();
				}
			} catch (Exception e) {
			}
		}
	}

	public static void main(String[] args) {
		new analog_clock();// ����
	}
}
