package obj_2;

public class obj_2_2 {

	public static double Newton_Method_CubeRoot(double X, int ntimes) {

		double xn = 1;
		System.out.println(X);
		for (int i = 0; i < ntimes; i++) { // n�� ���� ��� ����
			xn = xn - (xn * xn * xn - X) / (3 * xn * xn); // ���� ���
			System.out.println((i + 1) + "��: " + xn);
		}
		return xn;
	}

	public static void main(String[] args) {
		System.out.println("�������� ���ϱ�");
		Newton_Method_CubeRoot(1000, 15);
		Newton_Method_CubeRoot(1073741824, 37);
		Newton_Method_CubeRoot(Math.pow(2, 15), 20); // 2�� 15��
		Newton_Method_CubeRoot(Math.pow(2, 18), 24); // 2�� 18��
		Newton_Method_CubeRoot(Math.pow(2, 21), 27); // 2�� 21��
		Newton_Method_CubeRoot(Math.pow(2, 24), 31); // 2�� 24��
		Newton_Method_CubeRoot(Math.pow(2, 27), 34); // 2�� 27��
	}

}
