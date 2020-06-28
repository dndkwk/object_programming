//2015112232 백근주
package test;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		System.out.println("배열을 입력해 주세요");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine(); //배열을 받고 공백포함한 채로 str에 저장한다.
		
		String[] strnum = str.split("\\s+"); // str을 공백을 기준으로 잘라서 strnum에 배열로 저장한다.
		double sum = 0 ; //합을 저장할 변수
		System.out.println("Avr 출력"); 
		for(int i = 0 ; i < strnum.length;i++) {
			sum += Double.parseDouble(strnum[i]); //double로 자료형을 변환하여 sum에 하나씩 더한다.
			System.out.println("Avr["+ i +"]: " + sum/(i+1));        //중간 더한값을 개수로 나눈다.
		}
		input.close();
	}
}
