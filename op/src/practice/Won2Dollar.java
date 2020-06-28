package practice;

import java.util.Scanner;

abstract class Converter{
	abstract protected double convert(double src);
	abstract protected  String srcString();
	abstract protected  String desString();
	protected double rate;
	
	public void run() {
		Scanner scan= new Scanner(System.in);
		System.out.println(srcString() + "��"+ desString()+"�� �ٲߴϴ�.");
		System.out.println(srcString()+"�� �Է��ϼ���");
		double value = scan.nextDouble();
		double result = convert(value);
		System.out.println("���� ���: "+ result + desString()+"�Դϴ�.");
		scan.close();
		
	}
}


class Won2Dollar extends Converter {
	
	public Won2Dollar(int i) {
		this.rate = i;
	}
	
	public static void main(String[] args) {
		Won2Dollar toDollar = new Won2Dollar(1320);
		toDollar.run();
	}

	@Override
	protected double convert(double src) {
		// TODO Auto-generated method stub
		
		return (src*this.rate);
	}

	@Override
	protected String srcString() {
		// TODO Auto-generated method stub
		return "��";
	}

	@Override
	protected String desString() {
		// TODO Auto-generated method stub
		return "�޷�";
	}

	
}
