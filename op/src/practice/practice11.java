package practice;

import java.util.Scanner;

abstract class Calc { //����� �ʵ�� �޼ҵ�
	protected int a;
	protected int b;

	abstract protected void setValue(int a, int b); // �ǿ����� ���� ��ü ���� ����
	abstract protected int calculate();// Ŭ������ ������ �´� ������ �����ϰ� ��� ����
}

public class practice11 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�� ������ �����ڸ� �Է��Ͻÿ�>>");
		int a = scanner.nextInt();
		int b = scanner.nextInt();
		String operater = scanner.next(); // �����ڸ� �����ϴ� ����
		if (operater.equals("+")) { // �����ڿ� ���� ȣ�� ��ü�� �ٸ���.
			Add result = new Add(); // +�϶�
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("-")) {
			Sub result = new Sub(); // -�϶�
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("*")) {
			Mul result = new Mul(); // *�϶�
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else if (operater.equals("/")) {
			Div result = new Div(); // /�϶�
			result.setValue(a, b);
			System.out.println(result.calculate());

		} else {
			System.out.println("�߸� �Է��ϼ̽��ϴ�."); // �ش��ϴ� �����ڰ� ������ ���
		}
	}
}

class Add extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// �ǿ����ڰ� ����
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// + ������ ����� ���
		return (a + b);
	}
}

class Sub extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// �ǿ����ڰ� ����
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// - ������ ����� ���
		return (a - b);
	}
}

class Mul extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// �ǿ����ڰ� ����
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// * ������ ����� ���
		return (a * b);
	}
}

class Div extends Calc {
	@Override
	protected void setValue(int a, int b) {
		// �ǿ����ڰ� ����
		this.a = a;
		this.b = b;
	}

	@Override
	protected int calculate() {
		// / ������ ����� ���
		return (a / b);
	}

}
