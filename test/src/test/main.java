//2015112232 �����
package test;
import java.util.Scanner;

public class main {
	public static void main(String[] args) {
		
		System.out.println("�迭�� �Է��� �ּ���");
		Scanner input = new Scanner(System.in);
		String str = input.nextLine(); //�迭�� �ް� ���������� ä�� str�� �����Ѵ�.
		
		String[] strnum = str.split("\\s+"); // str�� ������ �������� �߶� strnum�� �迭�� �����Ѵ�.
		double sum = 0 ; //���� ������ ����
		System.out.println("Avr ���"); 
		for(int i = 0 ; i < strnum.length;i++) {
			sum += Double.parseDouble(strnum[i]); //double�� �ڷ����� ��ȯ�Ͽ� sum�� �ϳ��� ���Ѵ�.
			System.out.println("Avr["+ i +"]: " + sum/(i+1));        //�߰� ���Ѱ��� ������ ������.
		}
		input.close();
	}
}
