package obj_3;

import java.util.Scanner;

public class obj_3_4 {

	

	public static void MakeMatrix(int n) {
		int i, j, k;
		int[][] arr = new int[n][n];
		int count = 0; // 배열에 넣을 숫자
		
		if (n % 2 == 0) {
			// 배열에 나선형으로 넣기 n이 짝수
			for (i = n - 1; i >= 0; i--) {// ㄱ,ㄴ 자로 나뉘어서 넣는다.
				if (i % 2 == 0) {// ㄱ 자로 숫자넣기
					int start_row = n - 1 - (n - i - 1) / 2; // 시작 행
					int start_column = n - 1 - (n - i - 1) / 2; // 시작 열
					for (k = 0; k < 2 * (i + 1); k++) {
						if (k < i + 1) {// 아래로 꺾이기 전까지
							arr[start_row][start_column] = count;
							start_column--; // 열 증가
							count++;
						} else { // 아래로 꺾일때
							arr[start_row][start_column] = count;
							start_row--; // 행 증가
							count++;
						}
					}
				} else {// ㄴ자로 숫자넣기
					int start_row = (n - i) / 2; // 시작 행
					int start_column = (n - i) / 2; // 시작 열
					for (j = 0; j < 2 * i; j++) {
						if (j < i) { // 위로 꺾이기 전까지
							arr[start_row][start_column] = count;
							start_column++; // 열 증가
							count++;
						} else {// 위로 꺾일때
							arr[start_row][start_column] = count;
							start_row++; // 행 증가
							count++;
						}
					}
				}
			}
		} else {
			// 배열에 나선형으로 넣기 n이 홀수
			for (i = n - 1; i >= 0; i--) { // ㄱ,ㄴ,한가운데로 나눈다.
				if (i == 0) { // 한가운데 숫자 넣기
					arr[n / 2][n / 2] = count;
				}
				if (i % 2 == 1) { // ㄴ자로 숫자 넣기
					int start_row = n - 1 - (n - i - 1) / 2; // 시작 행 
					int start_column = n - 1 - (n - i - 1) / 2; // 시작 열
					for (k = 0; k < 2 * (i + 1); k++) {
						if (k < i + 1) { // 위로 꺾이기 전까지
							arr[start_row][start_column] = count;
							start_column--; // 열 감소
							count++;
						} else { // 위로 꺾일때
							arr[start_row][start_column] = count;
							start_row--; // 행 감소
							count++;
						}
					}
				} else { // ㄱ자로 숫자 넣기
					int start_row = (n - i) / 2; // 시작 행
					int start_column = (n - i) / 2; // 시작 열
					for (j = 0; j < 2 * i; j++) {
						if (j < i) { // 아래로 꺾이기 전까지
							arr[start_row][start_column] = count;
							start_column++; // 열 증가
							count++;
						} else { // 아래로 꺾일때
							arr[start_row][start_column] = count;
							start_row++; // 행 증가
							count++;
						}
					}
				}
			}
		}

		for (int row = 0; row < n; row++) { // 배열 출력
			for (int column = 0; column < n; column++) {
				System.out.print(arr[row][column] + " ");
				System.out.print('\t');
			}
			System.out.println(" ");
		}

	}

	public static void main(String[] args) {
		// 배열 나선형
		int n;
		System.out.println("정수 N을 입력하세요: ");
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		MakeMatrix(n);

	}

}
