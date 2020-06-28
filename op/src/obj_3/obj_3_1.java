package obj_3;

import java.util.Scanner;

public class obj_3_1 {
	// 배열
	public static void MakeMatrix(int n) {
		int row, column; // 행과 열
		int[][] arr = new int[n][n];

		for (row = 0; row < n; row++) {
			for (column = 0; column < n; column++) {
				arr[row][column] = row * n + column; // 행*n+열은 그 칸에 알맞는 숫자가 된다.
			}
		}

		for (int i = 0; i < n; i++) {// 배열 출력
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

		MakeMatrix(n); // 표를 만드는 함수
	}
}
