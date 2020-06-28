package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class practice_chap12 extends JFrame {

	public practice_chap12() {
		super("이미지 레이블 드래깅 연습& 이미지 그리기 연습");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		Container c = getContentPane();
		c.setLayout(new FlowLayout()); // FlowLayout 정렬

		setSize(500, 500);
		setVisible(true);
	}

	class MyPanel extends JPanel { // 배경사진 show/hide
		ImageIcon back = new ImageIcon("E:/school/op/src/practice/back.jpg");
		Image back_img = back.getImage(); // 배경 다시 그릴때 사용

		ImageIcon apple_icon = new ImageIcon("E:/school/op/src/practice/apple.jpg"); // 이미지 로딩
		JLabel imageapple = new JLabel(apple_icon); // 이미지 레이블

		ButtonGroup group = new ButtonGroup(); // 라디오 버튼 생성
		JRadioButton oval = new JRadioButton("초록원", true);
		JRadioButton apple = new JRadioButton("사과", false);

		boolean flag_apple = false;

		JButton bt = new JButton("Hide/Show"); // 버튼
		boolean show = true; // 버튼 조건

		private int ovalX = 100, ovalY = 100; // 원의 중심 좌표
		private final int RADIUS = 20; // 원의 반지름

		private Point startP = null; // 드래깅 시작 점

		public MyPanel() {
			imageapple.setSize(apple_icon.getIconHeight(), apple_icon.getIconWidth()); // 이미지 크기

			imageapple.addMouseListener(new MouseAdapter() { // 버튼 이벤트 생성
				@Override
				public void mousePressed(MouseEvent e) {
					if (apple.isSelected()) { // 사과 버튼이 눌려있을때
						startP = e.getPoint();
					}
				}
			});
			imageapple.addMouseMotionListener(new MouseMotionAdapter() {
				// 사과 드래그 이벤트
				@Override
				public void mouseDragged(MouseEvent e) {
					if (apple.isSelected()) {// 사과 버튼이 눌려있을때
						Point endP = e.getPoint();
						Component la = (JComponent) (e.getSource());
						Point p = la.getLocation();
						la.setLocation(p.x + endP.x - startP.x, p.y + endP.y - startP.y);
						la.getParent().repaint(); // 움직인 la의 위치에 다시 그리기
					}
				}

			});

			group.add(oval);// 버튼과 이미지 추가
			group.add(apple);

			add(bt); // 버튼 추가
			add(oval);
			add(apple);
			add(imageapple);

			bt.addActionListener(new ActionListener() { // 버튼 이벤트
				@Override
				public void actionPerformed(ActionEvent e) {
					show = !show; // hide/show
					MyPanel.this.repaint();
				}
			});

			addMouseMotionListener(new MouseMotionAdapter() { // 초록점 이벤트
				@Override
				public void mouseDragged(MouseEvent e) { // 초록점 라디오버튼이 선택됬을때만 드래그가능
					if (oval.isSelected()) {
						ovalX = e.getX();
						ovalY = e.getY();
						repaint(); // paintComponent()로 하여금 ovalX, ovalY의 위치에 다시 그리기가 지시
					}
				}
			});
		}

		@Override
		public void paintComponent(Graphics g) {
			// 초록점 + 배경그림
			super.paintComponent(g);
			if (show) { // true면 그리고 false면 안그림
				g.drawImage(back_img, 0, 0, this.getWidth(), this.getHeight(), this);
			}
			g.setColor(Color.GREEN);
			g.fillOval(ovalX, ovalY, RADIUS, RADIUS); // 반지름 20 픽셀 짜리의 채운 원 그리기
		}
	}

	public static void main(String[] args) {

		new practice_chap12();

	}

}
