package obj_2;

public class obj_2_2 {

	public static double Newton_Method_CubeRoot(double X, int ntimes) {

		double xn = 1;
		System.out.println(X);
		for (int i = 0; i < ntimes; i++) { // n¹ø ´ºÅÏ ¹æ¹ý Àû¿ë
			xn = xn - (xn * xn * xn - X) / (3 * xn * xn); // ´ºÅÏ ¹æ¹ý
			System.out.println((i + 1) + "¹ø: " + xn);
		}
		return xn;
	}

	public static void main(String[] args) {
		System.out.println("¼¼Á¦°ö±Ù ±¸ÇÏ±â");
		Newton_Method_CubeRoot(1000, 15);
		Newton_Method_CubeRoot(1073741824, 37);
		Newton_Method_CubeRoot(Math.pow(2, 15), 20); // 2ÀÇ 15½Â
		Newton_Method_CubeRoot(Math.pow(2, 18), 24); // 2ÀÇ 18½Â
		Newton_Method_CubeRoot(Math.pow(2, 21), 27); // 2ÀÇ 21½Â
		Newton_Method_CubeRoot(Math.pow(2, 24), 31); // 2ÀÇ 24½Â
		Newton_Method_CubeRoot(Math.pow(2, 27), 34); // 2ÀÇ 27½Â
	}

}
