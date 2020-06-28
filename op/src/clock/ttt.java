package clock;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ttt extends JFrame {

	int PlayerNum = 1;
	JPanel reset = new JPanel();
	JPanel matrix = new JPanel();
	JButton[] tempButton = new JButton[9];
	JLabel winner = new JLabel();
	boolean GameEnd=false;

	public ttt() {
		setTitle("ƽ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ���μ������� ���� ����
		Container c = getContentPane();

		this.drawwindow();
		this.setSize(600, 600);
		this.setVisible(true);
	}

	public void drawwindow() {
		matrix.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < 9; i++) {
			tempButton[i] = new JButton("");
			tempButton[i].setFont(new Font("Impact", Font.PLAIN, 22));
			matrix.add(tempButton[i]);
		}
		add(matrix, BorderLayout.CENTER);

		JButton reset_button = new JButton("�ٽ� ����");
		reset_button.setFont(new Font("����", Font.PLAIN, 22));
		winner.setText("����:      ");
		winner.setFont(new Font("����", Font.PLAIN, 22));
		reset.add(winner);
		reset.add(reset_button);
		add(reset, BorderLayout.SOUTH);

		MouseListener ml = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JButton temp = (JButton) e.getComponent();
				if(GameEnd == false) {
					if (temp.getText().equals("O") || temp.getText().equals("X")) {
						// �̹� ������ �� Ŭ���� ��
						return;
					} else if (PlayerNum % 2 == 1) { // �÷��̾� 1 �϶�
						PlayerNum++;
						temp.setText("O");

					} else if (PlayerNum % 2 == 0) { // �÷��̾� 2 �϶�
						PlayerNum++;
						temp.setText("X");
					}
					bingo(tempButton, winner);
				}
			}
		};

		MouseListener rl = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PlayerNum = 1;
				for (int i = 0; i < tempButton.length; i++) {
					tempButton[i].setText("");
				}

				winner.setText("����:      ");
				GameEnd=false;
			}
		};

		// �̺�Ʈ ó�� ����
		for (Component c : matrix.getComponents()) {
			c.addMouseListener(ml);
		}

		reset_button.addMouseListener(rl);

	}

	public void bingo(JButton[] tempbutton, JLabel winner) {
		// ���� ����
		// �� �� �����϶�
		if ((tempbutton[0].getText() == tempbutton[1].getText()) && (tempbutton[1].getText() == tempbutton[2].getText())) {
			if (tempbutton[0].getText() != "" && tempbutton[1].getText() != "" && tempbutton[2].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		} else if ((tempbutton[3].getText() == tempbutton[4].getText()) && (tempbutton[4].getText() == tempbutton[5].getText())) {
			if (tempbutton[3].getText() != "" && tempbutton[4].getText() != "" && tempbutton[5].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		} else if ((tempbutton[6].getText() == tempbutton[7].getText()) && (tempbutton[7].getText() == tempbutton[8].getText())) {
			if (tempbutton[6].getText() != "" && tempbutton[7].getText() != "" && tempbutton[8].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		} else if ((tempbutton[0].getText() == tempbutton[3].getText()) && (tempbutton[3].getText() == tempbutton[6].getText())) {
			if (tempbutton[0].getText() != "" && tempbutton[3].getText() != "" && tempbutton[6].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		} else if ((tempbutton[1].getText() == tempbutton[4].getText()) && (tempbutton[4].getText() == tempbutton[7].getText())) {
			if (tempbutton[1].getText() != "" && tempbutton[4].getText() != "" && tempbutton[7].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		} else if ((tempbutton[2].getText() == tempbutton[5].getText()) && (tempbutton[5].getText() == tempbutton[8].getText())) {
			if (tempbutton[2].getText() != "" && tempbutton[5].getText() != "" && tempbutton[8].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		}else if ((tempbutton[0].getText() == tempbutton[4].getText()) && (tempbutton[4].getText() == tempbutton[8].getText())) {
			//�밢�� ����
			if (tempbutton[0].getText() != "" && tempbutton[4].getText() != "" && tempbutton[8].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		}else if ((tempbutton[2].getText() == tempbutton[4].getText()) && (tempbutton[4].getText() == tempbutton[6].getText())) {
			if (tempbutton[2].getText() != "" && tempbutton[4].getText() != "" && tempbutton[6].getText() != "") {
				if (PlayerNum % 2 == 1) {
					winner.setText("����:  Player  2");
					GameEnd=true;
				} else {
					winner.setText("����:  Player  1");
					GameEnd=true;
				}
			}
		}

	}

	public static void main(String[] args) {
		new ttt();//����
	}

}
