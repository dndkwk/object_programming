package obj_3;

import java.util.Scanner;

public class obj_3_5 {

	public static void MakeMatrix(int n) {
		int p;
		int q;
		for (int y = 0; y < n; y++) {
			for (int x = 0; x < n; x++) {
				
				//가장자리에서 떨어진 정도를 나타내는 p
				p = Math.min(Math.min(x, y), Math.min(n - x - 1, n - y - 1));
				
				// ㄱ,ㄴ으로 나눠서 구한다
				if (x >= y) { // ㄱ 모양
					q = x + y - 2 * p; // 한 변을 이루는 요소가 2씩 작아진다.
				} else { // ㄴ 모양
					q = (n - 1 - 2 * p) * 4 - (x + y - 2 * p);
				}
				//가장자리에서 떨어진 정도와 몇번째 숫자인지 알려주는 q를 이용하여 그 칸에 맞는 숫자를 구한다.
				q = q + 4 * (p * n - (p * p));
				System.out.print(q + " ");
				System.out.print('\t');
			}

			System.out.println();
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
