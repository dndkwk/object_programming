package practice;

//2015112232�����

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class practice7_11_2 {

	static HashMap<String, String> store = new HashMap<String, String>();

	public practice7_11_2() {
		// ���� ������ �Է�
		store.put("�߽���", "�߽��ڽ�Ƽ");
		store.put("������", "������");
		store.put("������", "�ĸ�");
		store.put("����", "����");
		store.put("�׸���", "���׳�");
		store.put("����", "������");
		store.put("�Ϻ�", "����");
		store.put("�߱�", "������");
		store.put("���þ�", "��ũ��");
	}

	public void run() {
		//���� ����
		System.out.println("**** ���� ���߱� ������ �����մϴ�. ****");
		while (true) {
			System.out.print("�Է�:1, ����:2, ����:3>> ");
			Scanner scanner = new Scanner(System.in);
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				input();// �Է�
				break;
			case 2:
				quiz();// ����
				break;
			case 3:
				System.out.println("������ �����մϴ�.");//����
				scanner.close();
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");// ����
			}
		}
	}


	private boolean check(String s) {
		// �������� �ƴ��� �������ִ� �Լ�
		try {
			double n = Double.parseDouble(s);
			return true;// �����϶�
		} catch (NumberFormatException e) {
			return false;// �����϶�
		}
	}

	private void input() {
		// �Է�
		int n = store.size();
		System.out.println("���� " + n + "�� ����� ������ �ԷµǾ� �ֽ��ϴ�.");
		n = n + 1;
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("����� ���� �Է�" + n + ">> ");
			String country = scanner.next(); // ����� �Է� ����
			if (country.equals("�׸�")) {
				break;
			}
			if (check(country)) {
				System.out.println("�ٽ��Է�");
				continue;
			}

			String capital = scanner.next(); // ����� �Է�, ����

			if (check(capital)) {
				System.out.println("�ٽ��Է�");
				continue;
			}

			if (store.containsKey(country)) { // ����ڰ� �Է��� ���� �̹� �ִٸ�
				System.out.println(country + "�� �̹� �ֽ��ϴ�!");
				continue;
			}

			store.put(country, capital);// vector�� �߰�
			n++;
		}
	}

	private void quiz() {
		// ���� ����
		Set<String> key =store.keySet();
		Object[] array=key.toArray();
		while (true) {

			// ���� �߿��� �ϳ��� �����Ѵ�.
			int index = (int) (Math.random() * array.length); // ������ ���� ����

			// ����� ���� ����
			String country = (String)array[index];
			String capital = store.get(country);

			// ���� ���
			System.out.print(country + "�� ������? ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine(); // ������� �Է�
			if (input.equals("�׸�")) {
				break;
			}
			if (input.equals(capital))
				System.out.println("����!!");
			else
				System.out.println("�ƴմϴ�!!");
		}
	}


	public static void main(String[] args) {
		practice7_11_2 game = new practice7_11_2();
		game.run();// ����

	}

}
