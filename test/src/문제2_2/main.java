//2015112232�����
package ����2_2;

import java.util.*;

public class main {
	static int min = 1000000; // �񱳿� ���� ���� ����
	static int M = 40;   // ���ϴ� ��
	static int[] i;      // ���� for���� ����
	static int[] cc;     // ���� ���� �迭
	static int[] cv;     // ���� �� �迭
	static int sum = 0;  // ���� ��*������ ���� �޴� ����
	static int countsum = 0; // ���� �������� ���� �޴� ����

	public static void bruteforce(int count, int[] cv) {

		if (count == 0) { // count�� 0�̸�  �ּ� ���� ������ ã�´�.
			for (i[0] = 0; i[0] <= M / cv[0]; i[0]++) {
				for (int j = 0; j < cv.length; j++) {
					sum += cv[j] * i[j]; //����*���� ��� ���ļ�  sum�� ����
				}
				if (M == sum) {         //���ϴ� ��M�� sum�� ��
					for (int j = 0; j < cv.length; j++) {
						countsum += i[j];  // M�� sum�� ���ٸ� ������ ������ ������ ��ģ��.
					}
					if (min > countsum) {  //�ּ� ���� ���� min�� ���Ѵ�.
						for (int j = 0; j < cv.length; j++) {
							cc[j] = i[j]; //countsum�� �� �۴ٸ� cc[j]�� i[j]�� ���� �����Ѵ�.
						}
						min = countsum;  //min�� countsum�� ������ �ٲ۴�.
						countsum = 0;    //�ٽ� M==sum�� ��츦 ����� 0���� �ʱ�ȭ�Ѵ�.
					} else {
						countsum = 0;
					}
					sum = 0;
				} else {
					sum = 0;
				}
			}
		} else { //0�� �ƴ϶�� ����Լ��� ����
			for (i[count] = 0; i[count] <= M / cv[count]; i[count]++) {
				bruteforce(count - 1, cv);
			}
		}

	}

	public static void main(String[] args) {
		// bruteforceChange
		int count;

		System.out.println("Coin�� ������ �Է��� �ּ���");
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();

		i = new int[count];
		cv = new int[count];
		cc = new int[count];
		System.out.println("Coin�� ������ �Է��� �ּ���");
		for (int i = 0; i < count; i++) {
			cv[i] = sc.nextInt();
		}

		Arrays.sort(cv); //���� �����Ѵ�.

		bruteforce(count - 1, cv);

		for (int i = count - 1; i >= 0; i--) {
			System.out.println(cv[i]+":"+cc[i]);
		}
		
		sc.close();
	}
}
