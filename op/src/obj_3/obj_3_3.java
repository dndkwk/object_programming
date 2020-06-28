package obj_3;

import java.util.Scanner;

public class obj_3_3 {
	// 배열 안쓴 지그재그
	public static void MakeMatrix(int n) {
		int row, column;
		for (row = 0; row < n; row++) {
			for (column = 0; column < n; column++) {
				// 짝수줄 홀수줄을 구분으로 출력형식을 바꾼다.
				int i = row * n + column;
				if (row % 2 == 0) { // 짝수라면
					System.out.print(i);
					System.out.print('\t');
				} else {
					// 홀수줄은 최대값에서 내림차순
					System.out.print(n * (row + 1) - column - 1);
					System.out.print('\t');
				}
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
