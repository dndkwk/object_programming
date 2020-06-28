package practice;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class practice14_8 extends JFrame {

	public practice14_8() {
		setTitle("오디오 연주");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		Container c = getContentPane();
		c.setLayout(null);

		setSize(400, 400);
		setVisible(true);
	}

	class MyPanel extends JPanel {

		private Clip[] clip = new Clip[4];

		private JButton btn1 = new JButton("연주시작"); // 버튼생성
		private JButton btn2 = new JButton("연주 끝");
		private String[] path = { "E:/school/op/src/practice/wolf.wav", "E:/school/op/src/practice/dhol_drums.wav",
				"E:/school/op/src/practice/sirenpolice.wav", "E:/school/op/src/practice/hiphop.wav" };
		JCheckBox[] cb = new JCheckBox[4];
		private String[] text = { "audio\\wolf.wav", "audio\\dhol_drums.wav", "audio\\sirenpolice.wav",
				"audio\\hiphop.wav" };

		MyActionListener al = new MyActionListener();

		public MyPanel() {

			for (int i = 0; i < cb.length; i++) {
				cb[i] = new JCheckBox(text[i]);
				cb[i].setLocation(120, 30 + i * 40);
				cb[i].setSize(200, 50);
				add(cb[i]);
			}

			btn1.setLocation(100, 230);
			btn1.setSize(90, 30);
			add(btn1);
			btn1.addActionListener(al);
			btn2.setLocation(200, 230);
			btn2.setSize(90, 30);
			add(btn2);
			btn2.addActionListener(al);

			loadAudio(path);
		}

		void loadAudio(String[] pathName) {
			try {
				int i=0;
				for (i = 0; i < clip.length; i++) {
					clip[i] = AudioSystem.getClip(); // 비어있는 오디오 클립 만들기
					File audioFile = new File(pathName[i]);// 오디오 파일 경로명
					AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
					clip[i].open(audioStream); // 재생할 오디오 스트림 열기

				}
				clip[0].addLineListener(new LineListener() {
					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.START) {
							//만일 start 신호가 주어지면 cb의 text색을 바꾼다.
							cb[0].setForeground(Color.BLUE);
						}
						if(e.getType() == LineEvent.Type.CLOSE) {
							//만일 close 신호가 주어지면 cb의 text색을 초기화.
							cb[0].setForeground(null);
						}
					}
				});
				
				clip[1].addLineListener(new LineListener() {
					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.START) {
							//만일 start 신호가 주어지면 cb의 text색을 바꾼다.
							cb[1].setForeground(Color.BLUE);
						}
						if(e.getType() == LineEvent.Type.CLOSE) {
							//만일 close 신호가 주어지면 cb의 text색을 초기화.
							cb[1].setForeground(null);
						}
					}
				});
				
				clip[2].addLineListener(new LineListener() {
					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.START) {
							//만일 start 신호가 주어지면 cb의 text색을 바꾼다.
							cb[2].setForeground(Color.BLUE);
						}
						if(e.getType() == LineEvent.Type.CLOSE) {
							//만일 close 신호가 주어지면 cb의 text색을 초기화.
							cb[2].setForeground(null);
						}
					}
				});
				
				clip[3].addLineListener(new LineListener() {
					public void update(LineEvent e) {
						if (e.getType() == LineEvent.Type.START) {
							//만일 start 신호가 주어지면 cb의 text색을 바꾼다.
							cb[3].setForeground(Color.BLUE);
						}
						if(e.getType() == LineEvent.Type.CLOSE) {
							//만일 close 신호가 주어지면 cb의 text색을 초기화.
							cb[3].setForeground(null);
						}
					}
				});
			} catch (LineUnavailableException e) {
				e.printStackTrace();
			} catch (UnsupportedAudioFileException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}

		class MyActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				switch (e.getActionCommand()) {
				case "연주시작":

					try {

						for (int i = 0; i < clip.length; i++) {
							if (cb[i].isSelected()) {
								//체크된 노래를 순서대로 튼다.
									clip[i].start();
									while(!clip[i].isActive()) {
										clip[i].wait();
										System.out.println("ㅇㅇ");
									}
									clip[i].notify();
									clip[i].close();
							}
						}
					}
						catch (Exception a) {
						a.printStackTrace();
					}

					break;
				case "연주 끝":
					for (int i = 0; i < clip.length; i++) {
						//모두 멈추기
						clip[i].stop();
					}
					break;
				}
			}

		}

	}

	public static void main(String[] args) {
		new practice14_8(); //실행
	}

}
