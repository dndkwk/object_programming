package obj_3;

import java.util.Scanner;

public class obj_3_5 {

	public static void MakeMatrix(int n) {
		int p;
		int q;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				
				//�����ڸ����� ������ ������ ��Ÿ���� p
				p = Math.min(Math.min(x, y), Math.min(n - x - 1, n - y - 1));
				
				// ��,������ ������ ���Ѵ�
				if (x >= y) { // �� ���
					q = x + y - 2 * p; // �� ���� �̷�� ��Ұ� 2�� �۾�����.
				} else { // �� ���
					q = (n - 1 - 2 * p) * 4 - (x + y - 2 * p);
				}
				//�����ڸ����� ������ ������ ���° �������� �˷��ִ� q�� �̿��Ͽ� �� ĭ�� �´� ���ڸ� ���Ѵ�.
				q = q + 4 * (p * n - (p * p));
				System.out.print(q + " ");
				System.out.print('\t');
			}

			System.out.println();
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
