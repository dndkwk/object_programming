package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class practice_chap12 extends JFrame {

	public practice_chap12() {
		super("�̹��� ���̺� �巡�� ����& �̹��� �׸��� ����");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); // FlowLayout ����

		setSize(500, 500);
		setVisible(true);
	}

	class MyPanel extends JPanel { // ������ show/hide
		ImageIcon back = new ImageIcon("E:/school/op/src/practice/back.jpg");
		Image back_img = back.getImage(); // ��� �ٽ� �׸��� ���

		ImageIcon apple_icon = new ImageIcon("E:/school/op/src/practice/apple.jpg"); // �̹��� �ε�
		JLabel imageapple = new JLabel(apple_icon); // �̹��� ���̺�

		ButtonGroup group = new ButtonGroup(); // ���� ��ư ����
		JRadioButton oval = new JRadioButton("�ʷϿ�", true);
		JRadioButton apple = new JRadioButton("���", false);

		boolean flag_apple = false;

		JButton bt = new JButton("Hide/Show"); // ��ư
		boolean show = true; // ��ư ����

		private int ovalX = 100, ovalY = 100; // ���� �߽� ��ǥ
		private final int RADIUS = 20; // ���� ������

		private Point startP = null; // �巡�� ���� ��

		public MyPanel() {
			imageapple.setSize(apple_icon.getIconHeight(), apple_icon.getIconWidth()); // �̹��� ũ��

			imageapple.addMouseListener(new MouseAdapter() { // ��ư �̺�Ʈ ����
				@Override
				public void mousePressed(MouseEvent e) {
					if (apple.isSelected()) { // ��� ��ư�� ����������
						startP = e.getPoint();
					}
				}
			});
			imageapple.addMouseMotionListener(new MouseMotionAdapter() {
				// ��� �巡�� �̺�Ʈ
				@Override
				public void mouseDragged(MouseEvent e) {
					if (apple.isSelected()) {// ��� ��ư�� ����������
						Point endP = e.getPoint();
						Component la = (JComponent) (e.getSource());
						Point p = la.getLocation();
						la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
						la.getParent().repaint(); // ������ la�� ��ġ�� �ٽ� �׸���
					}
				}

			});

			group.add(oval);// ��ư�� �̹��� �߰�
			group.add(apple);

			add(bt); // ��ư �߰�
			add(oval);
			add(apple);
			add(imageapple);

			bt.addActionListener(new ActionListener() { // ��ư �̺�Ʈ
				@Override
				public void actionPerformed(ActionEvent e) {
					show = !show; // hide/show
					MyPanel.this.repaint();
				}
			});

			addMouseMotionListener(new MouseMotionAdapter() { // �ʷ��� �̺�Ʈ
				@Override
				public void mouseDragged(MouseEvent e) { // �ʷ��� ������ư�� ���É������� �巡�װ���
					if (oval.isSelected()) {
						ovalX = e.getX();
						ovalY = e.getY();
						repaint(); // paintComponent()�� �Ͽ��� ovalX, ovalY�� ��ġ�� �ٽ� �׸��Ⱑ ����
					}
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			// �ʷ��� + ���׸�
			super.paintComponent(g);
			if (show) { // true�� �׸��� false�� �ȱ׸�
				g.drawImage(back_img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
			g.setColor(Color.GREEN);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS); // ������ 20 �ȼ� ¥���� ä�� �� �׸���
		}
	}

	public static void main(String[] args) {

		new practice_chap12();

	}

}
