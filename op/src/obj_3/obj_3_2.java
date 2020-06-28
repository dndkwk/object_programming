package obj_3;

import java.util.Scanner;

public class obj_3_2 {
	// 배열 지그재그
	public static void MakeMatrix(int n) {
		int row, column;
		int[][] arr = new int[n][n];

		for (row = 0; row < n; row++) {
			for (column = 0; column < n; column++) {
				// 짝수줄 홀수줄을 구분으로 출력형식을 바꾼다.
				int i = row * n + column;
				if (row % 2 == 0) { // 짝수라면
					arr[row][column] = i;
				} else {
					// 홀수줄은 최대값에서 내림차순
					arr[row][column] = n * (row + 1) - column - 1;
				}
			}
		}

		// 배열 출력
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]);
				System.out.print('\t');
			}
			System.out.println(" ");
		}

	}

	public static void main(String[] args) {
		int n;
		System.out.println("정수 N을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		MakeMatrix(n);
	}

}
