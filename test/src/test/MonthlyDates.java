package test;

import java.util.Scanner;

public class MonthlyDates {

	public static void main(String[] args) {

		int i[][];
		i = new int[12][];

		System.out.println("������ �Է��Ͻÿ�.");
		Scanner sc = new Scanner(System.in);
		
		
		try {
			int year = sc.nextInt();
			i[0] = new int[31];// 1��
			if (year % 4 == 0) {// 4�⸶�� ����ó��
				i[1] = new int[29];// 2��
			} else {// ���
				i[1] = new int[28];// 2��
			}
			i[2] = new int[31];// 3��
			i[3] = new int[30];// 4��
			i[4] = new int[31];// 5��
			i[5] = new int[30];// 6��
			i[6] = new int[31];// 7��
			i[7] = new int[31];// 8��
			i[8] = new int[30];// 9��
			i[9] = new int[31];// 10��
			i[10] = new int[30];// 11��
			i[11] = new int[31];// 12��
			
			
		}catch(Exception e) {
			System.out.println("���ڰ� �ƴ�");
		}

	}

}
