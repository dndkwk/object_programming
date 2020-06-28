package obj_2;

public class obj_2_1 {

	public static double Newton_Method_SQRT(double X, int ntimes) {

		double xn = 1;
		System.out.println(X);
		for (int i = 0; i < ntimes; i++) { // n¹ø ´ºÅÏ ¹æ¹ý Àû¿ë
			xn = xn - (xn * xn - X) / (2 * xn); // ´ºÅÏ ¹æ¹ý
			System.out.println((i + 1) + "¹ø: " + xn);
		}
		return xn;
	}

	public static void main(String[] args) {
		System.out.println("Á¦°ö±Ù ±¸ÇÏ±â");
		Newton_Method_SQRT(100, 8);
		Newton_Method_SQRT(1073741824, 20);
		Newton_Method_SQRT(Math.pow(2, 16), 13); // 2ÀÇ 16½Â
		Newton_Method_SQRT(Math.pow(2, 20), 15); // 2ÀÇ 20½Â
		Newton_Method_SQRT(Math.pow(2, 24), 17); // 2ÀÇ 24½Â
		Newton_Method_SQRT(Math.pow(2, 28), 19); // 2ÀÇ 28½Â

	}

}
