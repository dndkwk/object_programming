package obj_3;

import java.util.Scanner;

public class obj_3_4 {

	

	public static void MakeMatrix(int n) {
		int i, j, k;
		int[][] arr = new int[n][n];
		int count = 0; // �迭�� ���� ����
		
		if (n % 2 == 0) {
			// �迭�� ���������� �ֱ� n�� ¦��
			for (i = n - 1; i >= 0; i--) {// ��,�� �ڷ� ����� �ִ´�.
				if (i % 2 == 0) {// �� �ڷ� ���ڳֱ�
					int start_row = n - 1 - (n - i - 1) / 2; // ���� ��
					int start_column = n - 1 - (n - i - 1) / 2; // ���� ��
					for (k = 0; k < 2 * (i + 1); k++) {
						if (k < i + 1) {// �Ʒ��� ���̱� ������
							arr[start_row][start_column] = count;
							start_column--; // �� ����
							count++;
						} else { // �Ʒ��� ���϶�
							arr[start_row][start_column] = count;
							start_row--; // �� ����
							count++;
						}
					}
				} else {// ���ڷ� ���ڳֱ�
					int start_row = (n - i) / 2; // ���� ��
					int start_column = (n - i) / 2; // ���� ��
					for (j = 0; j < 2 * i; j++) {
						if (j < i) { // ���� ���̱� ������
							arr[start_row][start_column] = count;
							start_column++; // �� ����
							count++;
						} else {// ���� ���϶�
							arr[start_row][start_column] = count;
							start_row++; // �� ����
							count++;
						}
					}
				}
			}
		} else {
			// �迭�� ���������� �ֱ� n�� Ȧ��
			for (i = n - 1; i >= 0; i--) { // ��,��,�Ѱ���� ������.
				if (i == 0) { // �Ѱ�� ���� �ֱ�
					arr[n / 2][n / 2] = count;
				}
				if (i % 2 == 1) { // ���ڷ� ���� �ֱ�
					int start_row = n - 1 - (n - i - 1) / 2; // ���� �� 
					int start_column = n - 1 - (n - i - 1) / 2; // ���� ��
					for (k = 0; k < 2 * (i + 1); k++) {
						if (k < i + 1) { // ���� ���̱� ������
							arr[start_row][start_column] = count;
							start_column--; // �� ����
							count++;
						} else { // ���� ���϶�
							arr[start_row][start_column] = count;
							start_row--; // �� ����
							count++;
						}
					}
				} else { // ���ڷ� ���� �ֱ�
					int start_row = (n - i) / 2; // ���� ��
					int start_column = (n - i) / 2; // ���� ��
					for (j = 0; j < 2 * i; j++) {
						if (j < i) { // �Ʒ��� ���̱� ������
							arr[start_row][start_column] = count;
							start_column++; // �� ����
							count++;
						} else { // �Ʒ��� ���϶�
							arr[start_row][start_column] = count;
							start_row++; // �� ����
							count++;
						}
					}
				}
			}
		}

		for (int row = 0; row < n; row++) { // �迭 ���
			for (int column = 0; column < n; column++) {
				System.out.print(arr[row][column] + " ");
				System.out.print('\t');
			}
			System.out.println(" ");
		}

	}

	public static void main(String[] args) {
		// �迭 ������
		int n;
		System.out.println("���� N�� �Է��ϼ���: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		MakeMatrix(n);

	}

}
