package practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class pracitce8 {

	static String delim = " |,|=|{|}|;|\r\n|\t|\"|+|()[]/\\"; // �����ڵ�

	public static boolean IsStringDouble(String s) { // ���ڿ��� �������� �Ǻ����ִ� �Լ�
		try {
			Double.parseDouble(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean checktype(String s) {
		// �ڷ����� ���
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
			while (scan.hasNextLine()) {// ���پ� arraylist�� ����
				array.add(scan.nextLine());
			}
			for (int i = 0; i < array.size(); i++) { // ���پ� �м�
				StringTokenizer st = new StringTokenizer(array.get(i), delim); // ���ڿ� ����
				while (st.hasMoreTokens()) { // ���е� ���ڸ� �������� ����Ǻ�
					String s = st.nextToken();
					if (checktype(s)) { // ���� �ڷ����� �߰ߵǸ�
						System.out.println(s);
						while (st.hasMoreTokens()) { // ���ڻ����޿� ����Ѵ�.
							s = st.nextToken();
							if (!IsStringDouble(s)) {// ���� �Ÿ���
								System.out.println(s);
							}
						}
					} else if (s.equals("class")) {// class�� �߰ߵǸ� ���� ���ڸ� ���
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
