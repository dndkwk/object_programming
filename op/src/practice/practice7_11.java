package practice;

//2015112232백근주
import java.util.Scanner;
import java.util.Vector;

class Nation {
	// 나라와 수도를 저장하는 클래스
	private String country;
	private String capital;

	public Nation(String country, String capital) {
		this.country = country;
		this.capital = capital;
	}

	public String getCountry() {
		// 나라 return
		return country;
	}

	public String getCapital() {
		// 수도 return
		return capital;
	}
}

public class practice7_11 {
	static Vector<Nation> store = new Vector<Nation>();// Nation을 받는 vector

	practice7_11() {
		// 사전 데이터 입력
		store.add(new Nation("멕시코", "멕시코시티"));
		store.add(new Nation("스페인", "리스본"));
		store.add(new Nation("프랑스", "파리"));
		store.add(new Nation("영국", "런던"));
		store.add(new Nation("그리스", "아테네"));
		store.add(new Nation("독일", "베를린"));
		store.add(new Nation("일본", "동경"));
		store.add(new Nation("중국", "베이찡"));
		store.add(new Nation("러시아", "모스크바"));
	}

	public void run() {
		// 게임 시작
		System.out.println("**** 수도 맞추기 게임을 시작합니다. ****");
		while (true) {
			System.out.print("입력:1, 퀴즈:2, 종료:3>> ");
			Scanner scanner = new Scanner(System.in);
			int menu = scanner.nextInt();
			switch (menu) {
			case 1:
				input();// 입력
				break;
			case 2:
				quiz();// 퀴즈
				break;
			case 3:
				System.out.println("게임을 종료합니다.");// 종료
				scanner.close();
				return;
			default:
				System.out.println("잘못된 입력입니다.");// 오류
			}
		}
	}

	private boolean contains(String country) {
		// 나라가 중복인지 알려주는 함수
		for (int i = 0; i < store.size(); i++) {
			if (store.get(i).getCountry().equals(country)) { // 사용자가 입력한 나라가 이미 있다면
				return true;
			}
		}
		return false;
	}

	private boolean check(String s) {
		// 숫자인지 아닌지 구별해주는 함수
		try {
			double n = Double.parseDouble(s);
			return true;// 숫자일때
		} catch (NumberFormatException e) {
			return false;// 문자일때
		}
	}

	private void input() {
		// 입력
		int n = store.size();
		System.out.println("현재 " + n + "개 나라와 수도가 입력되어 있습니다.");
		n = n + 1;
		while (true) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("나라와 수도 입력" + n + ">> ");
			String country = scanner.next(); // 사용자 입력 나라
			if (country.equals("그만")) {
				break;
			}
			if (check(country)) {
				System.out.println("다시입력");
				continue;
			}

			String capital = scanner.next(); // 사용자 입력, 수도

			if (check(capital)) {
				System.out.println("다시입력");
				continue;
			}

			if (contains(country)) { // 사용자가 입력한 나라가 이미 있다면
				System.out.println(country + "는 이미 있습니다!");
				continue;
			}

			store.add(new Nation(country, capital));// vector에 추가
			n++;
		}
	}

	private void quiz() {
		// 퀴즈 출제
		while (true) {

			// 나라 중에서 하나를 선택한다.
			int index = (int) (Math.random() * store.size()); // 랜덤한 위치 결정

			// 나라와 수도 저장
			Nation nation = store.get(index);
			String country = nation.getCountry();
			String capital = nation.getCapital();

			// 문제 출력
			System.out.print(country + "의 수도는? ");
			Scanner scanner = new Scanner(System.in);
			String input = scanner.nextLine(); // 사용자의 입력
			if (input.equals("그만")) {
				break;
			}
			if (input.equals(capital))
				System.out.println("정답!!");
			else
				System.out.println("아닙니다!!");
		}
	}

	public static void main(String[] args) {
		practice7_11 game = new practice7_11();
		game.run();// 시작
	}

}
