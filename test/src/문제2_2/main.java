//2015112232백근주
package 문제2_2;

import java.util.*;

public class main {
	static int min = 1000000; // 비교용 가장 작은 갯수
	static int M = 40;   // 원하는 값
	static int[] i;      // 다중 for문을 구별
	static int[] cc;     // 동전 개수 배열
	static int[] cv;     // 동전 값 배열
	static int sum = 0;  // 동전 값*개수의 합을 받는 변수
	static int countsum = 0; // 동전 개수들의 합을 받는 변수

	public static void bruteforce(int count, int[] cv) {

		if (count == 0) { // count가 0이면  최소 동전 개수를 찾는다.
			for (i[0] = 0; i[0] <= M / cv[0]; i[0]++) {
				for (int j = 0; j < cv.length; j++) {
					sum += cv[j] * i[j]; //개수*값을 모두 합쳐서  sum에 저장
				}
				if (M == sum) {         //원하는 값M과 sum을 비교
					for (int j = 0; j < cv.length; j++) {
						countsum += i[j];  // M과 sum이 같다면 쓰여진 동전의 개수를 합친다.
					}
					if (min > countsum) {  //최소 동전 개수 min과 비교한다.
						for (int j = 0; j < cv.length; j++) {
							cc[j] = i[j]; //countsum이 더 작다면 cc[j]에 i[j]를 각각 저장한다.
						}
						min = countsum;  //min을 countsum의 값으로 바꾼다.
						countsum = 0;    //다시 M==sum일 경우를 대비해 0으로 초기화한다.
					} else {
						countsum = 0;
					}
					sum = 0;
				} else {
					sum = 0;
				}
			}
		} else { //0이 아니라면 재귀함수를 실행
			for (i[count] = 0; i[count] <= M / cv[count]; i[count]++) {
				bruteforce(count - 1, cv);
			}
		}

	}

	public static void main(String[] args) {
		// bruteforceChange
		int count;

		System.out.println("Coin의 개수를 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();

		i = new int[count];
		cv = new int[count];
		cc = new int[count];
		System.out.println("Coin의 종류를 입력해 주세요");
		for (int i = 0; i < count; i++) {
			cv[i] = sc.nextInt();
		}

		Arrays.sort(cv); //값을 정렬한다.

		bruteforce(count - 1, cv);

		for (int i = count - 1; i >= 0; i--) {
			System.out.println(cv[i]+":"+cc[i]);
		}
		
		sc.close();
	}
}
