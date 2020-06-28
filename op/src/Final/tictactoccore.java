package Final;

public class tictactoccore {
	private int currentPlayerNum;
	private boolean isGameOver = false;
	private int[][] endStage;
	private int currentTurn = 1;
	
	public tictactoccore(int currentPlayerNum) {
		this.currentPlayerNum = currentPlayerNum;
	}

	public void changeTurn() {
		currentPlayerNum = (currentPlayerNum == 1) ? 2 : 1;
	}

	public int getCurrentPlayerNum() {
		return currentPlayerNum;
	}

	public void setCurrentPlayerNum(int currentPlayerNum) {
		this.currentPlayerNum = currentPlayerNum;
	}	

	public int[][] getEndStage() {
		return endStage;
	}

	public int inputCurrentStage(int[][] currentStage) {
		// ������ �����ٸ� �� �̻� �����ϴ� �ǹ̰� �����Ƿ� �Ǵ� �ߴ�
		if(isGameOver) {
			return -99;
		}		
		
		
		for(int i = 0; i < currentStage.length; i++) {
			String rowStr = "";
			String colStr = "";
			String diagStr1 = "";
			String diagStr2 = "";
			for(int j = 0; j < currentStage[i].length; j++) {
				rowStr += (currentStage[i][j] + "");
				colStr += (currentStage[j][i] + "");
			}
			for(int j = 0; j < currentStage.length; j++) {
				diagStr1 += currentStage[j][j];
				diagStr2 += currentStage[j][2 - j];
			}			
			
			// ���� �Ǵ�			
			
			if(isThisPlayerWin(2, rowStr, colStr, diagStr1, diagStr2)) {
				isGameOver = true;
				endStage = currentStage;
				return 2;
			} else if(isThisPlayerWin(1, rowStr, colStr, diagStr1, diagStr2)) {
				isGameOver = true;
				endStage = currentStage;
				return 1;
			} else if(currentTurn == 9) {
				return 99;
			} else {
				continue;
			}
		}
		currentTurn++;
		return 0;
	}
	
	private boolean isThisPlayerWin(int playerNum, String rowFrag, String colFrag, String diagFrag1, String diagFrag2) {
		String p = String.valueOf(playerNum);
		boolean result = false;
		String[] arr = {rowFrag, colFrag, diagFrag1, diagFrag2};
		for(int i = 0; i < arr.length; i++) {
			result = !arr[i].contains("0") && arr[i].equals(p + p + p);
			if (result)	return result;
		}
		return result;
	}
	
	public void resetGame(int currentPlayerNum) {
		this.isGameOver = false;
		this.currentPlayerNum = currentPlayerNum;
		this.endStage = null;
		this.currentTurn = 1;
	}
	
	
}
