//2015112232�����
package ����2;
import java.util.*;
public class main {
	public static void main(String[] args) {
		// GreedyBetterChange
		int M = 40; // �ٲܷ��� �� M
		int count; // ������ ���� ������ ������ ����

		System.out.println("Coin�� ������ �Է��� �ּ���"); //������ ���� ������ ��´�
		Scanner input1 = new Scanner(System.in);
		count = input1.nextInt();

		int[] cv = new int[count]; //������  ���� �޴� �迭
		int[] cc = new int[count]; //���� �������� ������ �޴� �迭 
		System.out.println("Coin�� ������ �Է��� �ּ���");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < count; i++) { //���� ������ count�� �޾Ƽ� �迭�� ����
			cv[i] = sc.nextInt();
		}

		Arrays.sort(cv); //���� ������ ����

		for (int i = count - 1; i >= 0; i--) { 
			cc[i] = M / cv[i];	  //���� ū ������ �ʿ��� ������ ��� �� ������ �迭�� ����
			M = M - cc[i] * cv[i];    //��*������ M���� ����
		}
		
		for (int i = count-1; i >= 0; i--) {
			System.out.println(cv[i] + ": " + cc[i]); //���� : ���� �� ����Ѵ�.
		}

		input1.close();
		sc.close();
	}
}
