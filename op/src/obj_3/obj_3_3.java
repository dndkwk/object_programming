package obj_3;

import java.util.Scanner;

public class obj_3_3 {
	// �迭 �Ⱦ� �������
	public static void MakeMatrix(int n) {
		int row, column;
		for (row = 0; row < n; row++) {
			for (column = 0; column < n; column++) {
				// ¦���� Ȧ������ �������� ��������� �ٲ۴�.
				int i = row * n + column;
				if (row % 2 == 0) { // ¦�����
					System.out.print(i);
					System.out.print('\t');
				} else {
					// Ȧ������ �ִ밪���� ��������
					System.out.print(n * (row + 1) - column - 1);
					System.out.print('\t');
				}
			}
			System.out.println(" ");
		}
	}

	public static void main(String[] args) {
		int n;
		System.out.println("���� N�� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		MakeMatrix(n);

	}

}
