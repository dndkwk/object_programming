package obj_3;

import java.util.Scanner;

public class obj_3_1 {
	// �迭
	public static void MakeMatrix(int n) {
		int row, column; // ��� ��
		int[][] arr = new int[n][n];

		for (row = 0; row < n; row++) {
			for (column = 0; column < n; column++) {
				arr[row][column] = row * n + column; // ��*n+���� �� ĭ�� �˸´� ���ڰ� �ȴ�.
			}
		}

		for (int i = 0; i < n; i++) {// �迭 ���
			for (int j = 0; j < n; j++) {
				System.out.print(arr[i][j]);
				System.out.print('\t');
			}
			System.out.println(" ");
		}

	}

	public static void main(String[] args) {
		int n;
		System.out.println("���� N�� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		MakeMatrix(n); // ǥ�� ����� �Լ�
	}
}
