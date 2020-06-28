//2015112232백근주
package 문제2;
import java.util.*;
public class main {
	public static void main(String[] args) {
		// GreedyBetterChange
		int M = 40; // 바꿀려는 값 M
		int count; // 코인의 종류 개수를 저장할 변수

		System.out.println("Coin의 개수를 입력해 주세요"); //코인의 종류 개수를 얻는다
		Scanner input1 = new Scanner(System.in);
		count = input1.nextInt();

		int[] cv = new int[count]; //코인의  값을 받는 배열
		int[] cc = new int[count]; //코인 종류들의 개수를 받는 배열 
		System.out.println("Coin의 종류를 입력해 주세요");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < count; i++) { //코인 값들을 count번 받아서 배열에 저장
			cv[i] = sc.nextInt();
		}

		Arrays.sort(cv); //코인 값들을 정렬

		for (int i = count - 1; i >= 0; i--) { 
			cc[i] = M / cv[i];	  //가장 큰 값부터 필요한 개수를 얻고 그 개수를 배열에 저장
			M = M - cc[i] * cv[i];    //값*개수를 M에서 뺀다
		}
		
		for (int i = count-1; i >= 0; i--) {
			System.out.println(cv[i] + ": " + cc[i]); //종류 : 개수 를 출력한다.
		}

		input1.close();
		sc.close();
	}
}
