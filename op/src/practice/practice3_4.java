package practice;

import java.util.StringTokenizer;

class token {
	//예시문
	static String input = 
			"class Example{\r\n"+
			"	int a = 1, b = 6;\r\n"+
			"	long c;\r\n"+
			"}\r\n"+
			"\r\n"+
			"class Example2{\r\n"
			+"}\r\n";
	static String delim=" |,|=|{|}|;|\r\n|	"; //구분자들
}

public class practice3_4 {
	
	public static boolean IsStringDouble(String s) { //문자열이 숫자인지 판별해주는 함수
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}

	public static void main(String[] args) {
		System.out.println("input >>>");
		System.out.println(token.input); //예시출력
		StringTokenizer st = new StringTokenizer(token.input,token.delim); //문자열 구분
		String[] arr = new String[st.countTokens()]; //구분한 문자열을 저장할 string배열
		int i = 0;
		while(st.hasMoreTokens()) { //배열에 구분된 문자열들 저장
			arr[i]=st.nextToken();
			i++;
		}
		
		System.out.println("output >>>");
		for(int j=0;j<arr.length;j++) {
			if(!IsStringDouble(arr[j])) { //만약 숫자라면 출력하지 않는다
				System.out.println(arr[j]);
			}
		}
		
	}

}
