package Final;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class tictactoc extends JFrame {
	
	private static final long serialVersionUID = 1L;

	JLabel title = new JLabel("TicTacToe | ");
	JLabel dispCurrentPlayer = new JLabel("Player 0");
	private int score1 = 0;
	private int score2 = 0;
	JLabel scoreLabel = new JLabel(" | " + score1 + " : " + score2);
	JButton startNewGame = new JButton("�� ���� ����");
	
	JPanel titleBar = new JPanel();
	JPanel nineRoom = new JPanel();
	
	private final int START_PLAYER = 1;
	private boolean isGameEnd = false;
	tictactoccore ttt = new tictactoccore(START_PLAYER);
	
	public tictactoc() {
		  super("TicTacToe");
	        this.setSize(400,300);
	        this.setLocationRelativeTo(null);
	        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	        
	        this.drawWindow();
	        this.setVisible(true);       
	}
	
	public void drawWindow() {
		titleBar.add(title);
		titleBar.add(dispCurrentPlayer);
		titleBar.add(scoreLabel);
		titleBar.add(startNewGame);
		
		dispCurrentPlayer.setText("Player " + START_PLAYER);
		add(titleBar, BorderLayout.NORTH);
		
		nineRoom.setLayout(new GridLayout(3,3));
		for(int i = 0; i < 9; i++) {
			JButton tempButton = new JButton("");
			tempButton.setFont(new Font("Impact", Font.PLAIN, 22));
			nineRoom.add(tempButton);
	}
		add(nineRoom, BorderLayout.CENTER);
		MouseListener ml = new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JButton tempButton = (JButton)e.getComponent();
				// System.out.println(ttt.getCurrentPlayerNum());
				if(isGameEnd) {
					return;
				}
				if(tempButton.getText().equals("O") || tempButton.getText().equals("X")) {
					JOptionPane.showMessageDialog(nineRoom, "�̹� �� ���Դϴ�.");
					return;
				}
				else if(ttt.getCurrentPlayerNum() == 1) {
					tempButton.setText("O");
					dispCurrentPlayer.setText("Player " + 2);
				} else {
					tempButton.setText("X");
					dispCurrentPlayer.setText("Player " + 1);
				}
				ttt.changeTurn();
				System.out.print("(" + e.getX() + ", " + e.getY() + ") ");
				
				int[][] ticArr = new int[3][3];
				for(int i = 0; i < ticArr.length; i++) {
					for(int j = 0; j < ticArr[0].length; j++) {
						String pl = ((JButton)nineRoom.getComponent(j + i * 3)).getText();
						if(pl.equals("O"))	ticArr[i][j] = 1;
						else if(pl.equals("X"))	ticArr[i][j] = 2;
						else	ticArr[i][j] = 0;
					}					
				}
				
				int result = ttt.inputCurrentStage(ticArr);
				System.out.println("result: " + result);
				if(result == 1 || result == 2) {
					JOptionPane.showMessageDialog(nineRoom, "�÷��̾� " + result + "�� �¸��Դϴ�.");
					if(result == 1) {
						score1++;
					} else {
						score2++;
					}
					scoreLabel.setText(" | " + score1 + " : " + score2);
					isGameEnd = true;
				} else if (result == 99) {
					JOptionPane.showMessageDialog(nineRoom, "�����ϴ�.");
					isGameEnd = true;
				}
				
			}
		};
		
		for(Component c : nineRoom.getComponents()) {
			c.addMouseListener(ml);
		}
		
		startNewGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ttt.resetGame(START_PLAYER);
				isGameEnd = false;
				for(int i = 0; i < nineRoom.getComponents().length; i++) {
					((JButton)nineRoom.getComponent(i)).setText("");
				}
			
			}
		});
		
	}
		
	public static void main(String[] args) {
		
		  // �׷��� ���� thread ����ϱ�
        SwingUtilities.invokeLater(new Thread()    
        {
            public void run() {
                new tictactoc();
            }            
        });     
	}

}
