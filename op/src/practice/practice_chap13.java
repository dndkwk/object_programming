package practice;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class practice_chap13 extends JFrame {
	public practice_chap13() {

		super("스레드를 가진 겜블링");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		Container c = getContentPane();
		c.setLayout(null); // null 정렬

		setSize(300, 200);
		setVisible(true);

	}

	class MyPanel extends JPanel {
		JLabel[] la = new JLabel[3];
		JLabel s = new JLabel("마우스를 클릭할 때 마다 게임합니다.");
		GamblingThread GT = new GamblingThread(la, s);

		MyPanel() {

			for (int i = 0; i < 3; i++) {
				la[i] = new JLabel("0");
				la[i].setSize(30, 30);
				la[i].setLocation(60 + 80 * i, 50); // 위치
				la[i].setOpaque(true);
				la[i].setBackground(Color.MAGENTA); // 배경 색
				la[i].setForeground(Color.YELLOW); // 글자 색
				la[i].setFont(new Font("궁서", Font.ITALIC, 30)); // 글자 크기
				la[i].setHorizontalAlignment(JLabel.CENTER); // 글자 정렬
				add(la[i]);
			}
			s.setSize(220, 30);
			s.setLocation(30, 100);
			s.setHorizontalAlignment(JLabel.CENTER); // 글자 정렬
			add(s);
			GT.start();
			
			addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (!GT.getgambling()) { // 시작 안됬을때만 시작
						GT.startGambling();
					}
				}
			});
		}

	}

	class GamblingThread extends Thread {
		boolean gambling = false; // 스레드의 작동 여부 설정. 초기값 = false
		long delay = 200;
		JLabel[] number = new JLabel[3]; // 숫자 레이블
		JLabel s; // 결과 알려주는 레이블

		GamblingThread(JLabel[] number, JLabel s) {
			this.number = number;
			this.s = s;
		}

		boolean getgambling() {
			return gambling;
		}

		synchronized public void waitForGambling() { // 스레드의 run()에서 호출
			if (!gambling) { // 마우스 클릭에 의해 gambling이 true가 될 때까지 기다림
				try {
					this.wait();
				} catch (InterruptedException e) {
					return;
				}
			}
		}

		synchronized public void startGambling() { // 마우스 클릭 핸들러에서 호출
			gambling = true; // 마우스 클릭으로 스레드가 게임을 진행하도록 지시
			this.notify(); // 기다리는 스레드를 깨움
		}

		public void run() {
			while (true) {
				waitForGambling(); // 마우스 클릭이 일어나기를 기다린다.
				try {
					s.setText(null);
					int a = (int) (Math.random() * 5);
					int b = (int) (Math.random() * 5);
					int c = (int) (Math.random() * 5);

					number[0].setText(Integer.toString(a)); // 라벨에 숫자 넣기
					sleep(delay);// 200ms 간격으로 3번 sleep()을 하면서 숫자를 출력한다.
					number[1].setText(Integer.toString(b));
					sleep(delay);
					number[2].setText(Integer.toString(c));
					sleep(delay);

					if ((a == b) && (b == c)) {// 게임이 성공하였는지 판별하여 메시지를 출력한다.
						s.setText("축하합니다!!");
					} else {
						s.setText("아쉽군요");
					}

				} catch (InterruptedException e) {
					return;
				}
				gambling = false;// 이제 다음 게임이 가능하도록 설정한다.
			}
		}
	}

	
	public static void main(String[] args) {
		new practice_chap13();
	}

}
