package practice;

import java.util.Scanner;

abstract class Calc { //공통된 필드와 메소드
	protected int a;
	protected int b;

	abstract protected void setValue(int a, int b); // 피연산자 값을 객체 내에 저장
	abstract protected int calculate();// 클래스의 목적에 맞는 연산을 실행하고 결과 리턴
}

public class practice11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("두 정수와 연산자를 입력하시오>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operater = scanner.next(); // 연산자를 저장하는 변수
		if (operater.equals("+")) { // 연산자에 따라 호출 객체가 다르다.
			Add result = new Add(); // +일때
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("-")) {
			Sub result = new Sub(); // -일때
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("*")) {
			Mul result = new Mul(); // *일때
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("/")) {
			Div result = new Div(); // /일때
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else {
			System.out.println("잘못 입력하셨습니다."); // 해당하는 연산자가 없을때 출력
		}
	}
}

class Add extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// 피연산자값 저장
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// + 연산자 실행과 출력
		return (a + b);
	}
}

class Sub extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// 피연산자값 저장
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// - 연산자 실행과 출력
		return (a - b);
	}
}

class Mul extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// 피연산자값 저장
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// * 연산자 실행과 출력
		return (a * b);
	}
}

class Div extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// 피연산자값 저장
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// / 연산자 실행과 출력
		return (a / b);
	}

}
