package practice;

import java.util.StringTokenizer;

class token {
	//���ù�
	static String input = 
			"class Example{\r\n"+
			"	int a = 1, b = 6;\r\n"+
			"	long c;\r\n"+
			"}\r\n"+
			"\r\n"+
			"class Example2{\r\n"
			+"}\r\n";
	static String delim=" |,|=|{|}|;|\r\n|	"; //�����ڵ�
}

public class practice3_4 {
	
	public static boolean IsStringDouble(String s) { //���ڿ��� �������� �Ǻ����ִ� �Լ�
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println("input >>>");
		System.out.println(token.input); //�������
		StringTokenizer st = new StringTokenizer(token.input,token.delim); //���ڿ� ����
		String[] arr = new String[st.countTokens()]; //������ ���ڿ��� ������ string�迭
		int i = 0;
		while(st.hasMoreTokens()) { //�迭�� ���е� ���ڿ��� ����
			arr[i]=st.nextToken();
			i++;
		}
		
		System.out.println("output >>>");
		for(int j=0;j<arr.length;j++) {
			if(!IsStringDouble(arr[j])) { //���� ���ڶ�� ������� �ʴ´�
				System.out.println(arr[j]);
			}
		}
		
	}

}
