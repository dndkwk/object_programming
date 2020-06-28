package practice;

//2015112232백근주
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class practice9 extends JFrame {

	practice9() {
		setTitle("계산기 프레임");// 프레임 생성
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 종료시 프로세스도 종료

		Container c = getContentPane();// pane생성
		JPanel north = new JPanel(); // 각각의 패널 생성
		JPanel south = new JPanel();
		JPanel center = new JPanel();

		north.setBackground(Color.LIGHT_GRAY);// 색깔 맞추기
		south.setBackground(Color.LIGHT_GRAY);
		center.setLayout(new GridLayout(5, 4));// gridlayout형식으로 버튼 배치

		c.add(center, BorderLayout.CENTER); // pane에 각각의 위치에 넣기
		c.add(north, BorderLayout.NORTH);
		c.add(south, BorderLayout.SOUTH);

		JLabel input1 = new JLabel("수식입력"); // 글자와 텍스트필드 추가
		JTextField text1 = new JTextField(15);
		north.add(input1);
		north.add(text1);

		JLabel input2 = new JLabel("계산결과");// 글자와 텍스트필드 추가
		JTextField text2 = new JTextField(15);
		south.add(input2);
		south.add(text2);

		for (int i = 0; i < 20; i++) {// 각각의 위치에 글자 넣어주기
			JButton b = new JButton();
			String[] s = { "CE", "계산", "제곱", "세제곱", "제곱근", "세제곱근", "+", "-", "x", "/" };
			center.add(b);
			if (i < 10) {
				b.setText(i + "");
			} else {
				b.setText(s[i - 10]);
			}
			if (i > 15) {
				b.setOpaque(true);
				b.setBackground(Color.CYAN); // 배경색 설정
			}

		}
		setVisible(true);// 보이게 만들기
	}

	public static void main(String[] args) {
		new practice9();// 생성
	}
}
