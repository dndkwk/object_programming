package practice;

//2015112232�����
import java.util.Scanner;
import java.util.Vector;

class Nation {
	// ����� ������ �����ϴ� Ŭ����
	private String country;
	private String capital;

	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		// ���� return
		return country;
	}

	public String getCapital() {
		// ���� return
		return capital;
	}
}

public class practice7_11 {
	static Vector<Nation> store = new Vector<Nation>();// Nation�� �޴� vector

	practice7_11() {
		// ���� ������ �Է�
		store.add(new Nation("�߽���", "�߽��ڽ�Ƽ"));
		store.add(new Nation("������", "������"));
		store.add(new Nation("������", "�ĸ�"));
		store.add(new Nation("����", "����"));
		store.add(new Nation("�׸���", "���׳�"));
		store.add(new Nation("����", "������"));
		store.add(new Nation("�Ϻ�", "����"));
		store.add(new Nation("�߱�", "������"));
		store.add(new Nation("���þ�", "��ũ��"));
	}

	public void run() {
		// ���� ����
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
				System.out.println("������ �����մϴ�.");// ����
				scanner.close();
				return;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");// ����
			}
		}
	}

	private boolean contains(String country) {
		// ���� �ߺ����� �˷��ִ� �Լ�
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getCountry().equals(country)) { // ����ڰ� �Է��� ���� �̹� �ִٸ�
				return true;
			}
		}
		return false;
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

			if (contains(country)) { // ����ڰ� �Է��� ���� �̹� �ִٸ�
				System.out.println(country + "�� �̹� �ֽ��ϴ�!");
				continue;
			}

			store.add(new Nation(country, capital));// vector�� �߰�
			n++;
		}
	}

	private void quiz() {
		// ���� ����
		while (true) {

			// ���� �߿��� �ϳ��� �����Ѵ�.
			int index = (int) (Math.random() * store.size()); // ������ ��ġ ����

			// ����� ���� ����
			Nation nation = store.get(index);
			String country = nation.getCountry();
			String capital = nation.getCapital();

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
		practice7_11 game = new practice7_11();
		game.run();// ����
	}

}
