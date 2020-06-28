package test;

import java.util.Scanner;

public class MonthlyDates {

	public static void main(String[] args) {

		int i[][];
		i = new int[12][];

		System.out.println("연도를 입력하시오.");
		Scanner sc = new Scanner(System.in);
		
		
		try {
			int year = sc.nextInt();
			i[0] = new int[31];// 1월
			if (year % 4 == 0) {// 4년마다 윤년처리
				i[1] = new int[29];// 2월
			} else {// 평년
				i[1] = new int[28];// 2월
			}
			i[2] = new int[31];// 3월
			i[3] = new int[30];// 4월
			i[4] = new int[31];// 5월
			i[5] = new int[30];// 6월
			i[6] = new int[31];// 7월
			i[7] = new int[31];// 8월
			i[8] = new int[30];// 9월
			i[9] = new int[31];// 10월
			i[10] = new int[30];// 11월
			i[11] = new int[31];// 12월
			
			
		}catch(Exception e) {
			System.out.println("숫자가 아님");
		}

	}

}
