package practice;

import javax.swing.*;
import java.awt.*;

public class practice14_11 extends JFrame {

	public practice14_11() {
		setTitle("ÅÇÆÒ ¸¸µé±â ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		JTabbedPane pane = createTabbedPane(); // ÅÇÆÒÀ» »ý¼ºÇÑ´Ù
		c.add(pane, BorderLayout.CENTER); // ÅÇÆÒÀ» ÄÁÅÙÆ®ÆÒ¿¡ ºÎÂøÇÑ´Ù.
		setSize(250, 250);
		setVisible(true);

	}

	private JTabbedPane createTabbedPane() {
		JTabbedPane pane = new JTabbedPane();
		pane.addTab("tab1", new JLabel(new ImageIcon("E:/school/op/src/practice/img1.jpg"))); // Ã¹¹øÂ° ÅÇ
		
		pane.addTab("tab2", new JLabel(new ImageIcon("E:/school/op/src/practice/img2.jpg"))); // µÎ¹øÂ° ÅÇ
		
		pane.addTab("tab3", new MyPanel()); // ¼¼¹øÂ° ÅÇ
		
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
			g.drawString("tab 3¿¡ µé¾î°¡´Â JPanel ÀÔ´Ï´Ù",30,50);
		}
		
		
	}
	
	
	public static void main(String[] args) {
		new practice14_11();

	}

}
