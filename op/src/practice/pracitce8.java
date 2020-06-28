package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pracitce8 {

	static String delim = " |,|=|{|}|;|\r\n|\t|\"|+|()[]/\\"; // 구분자들

	public static boolean IsStringDouble(String s) { // 문자열이 숫자인지 판별해주는 함수
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean checktype(String s) {
		// 자료형만 출력
		if (s.equals("boolean")) {
			return true;
		} else if (s.equals("byte")) {
			return true;
		} else if (s.equals("int")) {
			return true;
		} else if (s.equals("short")) {
			return true;
		} else if (s.equals("long")) {
			return true;
		} else if (s.equals("char")) {
			return true;
		} else if (s.equals("float")) {
			return true;
		} else if (s.equals("double")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		System.out.println("input >>>");

		try {
			File file = new File("C:\\Users\\Baek Guen Joo\\Desktop\\Example.java");
			Scanner scan = new Scanner(file);
			ArrayList<String> array = new ArrayList<String>();
			while (scan.hasNextLine()) {// 한줄씩 arraylist에 저장
				array.add(scan.nextLine());
			}
			for (int i = 0; i < array.size(); i++) { // 한줄씩 분석
				StringTokenizer st = new StringTokenizer(array.get(i), delim); // 문자열 구분
				while (st.hasMoreTokens()) { // 구분된 문자를 기준으로 출력판별
					String s = st.nextToken();
					if (checktype(s)) { // 만약 자료형이 발견되면
						System.out.println(s);
						while (st.hasMoreTokens()) { // 숫자빼고쭈욱 출력한다.
							s = st.nextToken();
							if (!IsStringDouble(s)) {// 숫자 거르기
								System.out.println(s);
							}
						}
					} else if (s.equals("class")) {// class가 발견되면 다음 문자를 출력
						System.out.println(st.nextToken());
					}
				}
			}
			scan.close();
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFoundException");
		}

	}

}
