package practice;

import java.util.Scanner;

class Circle {
	private double x;
	private double y;
	private int radius;

	public Circle(double x, double y, int radius) {
		this.x = x;
		this.y = y;
		this.radius = radius;
	}

	public void show() {
		System.out.println("(" + x + "," + y + ")" + radius);
	}

}

public class practice5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		Circle c[] = new Circle[3];

		for (int i = 0; i < c.length; i++) {
			System.out.println("x,y,radius >>");
			double x = scanner.nextDouble(); // x���� �а�
			double y = scanner.nextDouble();// y���� �а�
			int radius = scanner.nextInt();// radius���� �а�
			c[i] =new Circle(x, y, radius);
		}

		for (int i = 0; i < c.length; i++) {
			// ��� circle��ü ���
			c[i].show();
		}

	}

}
