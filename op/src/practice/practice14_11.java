package practice;

import javax.swing.*;
import java.awt.*;

public class practice14_11 extends JFrame {

	public practice14_11() {
		setTitle("���� ����� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane(); // ������ �����Ѵ�
		c.add(pane, BorderLayout.CENTER); // ������ ����Ʈ�ҿ� �����Ѵ�.
		setSize(250, 250);
		setVisible(true);

	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("tab1", new JLabel(new ImageIcon("E:/school/op/src/practice/img1.jpg"))); // ù��° ��
		
		pane.addTab("tab2", new JLabel(new ImageIcon("E:/school/op/src/practice/img2.jpg"))); // �ι�° ��
		
		pane.addTab("tab3", new MyPanel()); // ����° ��
		
		pane.addTab("tab4", new JLabel(new ImageIcon("E:/school/op/src/practice/img3.jpg")));
		
		return pane;
	}
	
	class MyPanel extends JPanel{
		public MyPanel() {
			this.setBackground(Color.YELLOW);
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.RED);
			g.fillRect(10, 10, 50, 50);
			g.setColor(Color.BLUE);
			g.fillOval(10,70,50, 50);
			g.setColor(Color.BLACK);
			g.drawString("tab 3�� ���� JPanel �Դϴ�",30,50);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new practice14_11();

	}

}
