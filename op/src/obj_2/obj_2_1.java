package obj_2;

public class obj_2_1 {

	public static double Newton_Method_SQRT(double X, int ntimes) {

		double xn = 1;
		System.out.println(X);
		for (int i = 0; i < ntimes; i++) { // n�� ���� ��� ����
			xn = xn - (xn * xn - X) / (2 * xn); // ���� ���
			System.out.println((i + 1) + "��: " + xn);
		}
		return xn;
	}

	public static void main(String[] args) {
		System.out.println("������ ���ϱ�");
		Newton_Method_SQRT(100, 8);
		Newton_Method_SQRT(1073741824, 20);
		Newton_Method_SQRT(Math.pow(2, 16), 13); // 2�� 16��
		Newton_Method_SQRT(Math.pow(2, 20), 15); // 2�� 20��
		Newton_Method_SQRT(Math.pow(2, 24), 17); // 2�� 24��
		Newton_Method_SQRT(Math.pow(2, 28), 19); // 2�� 28��

	}

}
