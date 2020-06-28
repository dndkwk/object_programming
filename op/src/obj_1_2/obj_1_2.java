package obj_1_2;

import java.math.BigDecimal;

public class obj_1_2 {

	private static final int byteSize = 8;

	public static byte[] intToByteArray(int value) {
		// 정수를 바이트 배열로
		byte[] byteArray = new byte[4];
		byteArray[0] = (byte) (value >> 24); // value를 24비트만큼 오른쪽으로 옮긴다.
		byteArray[1] = (byte) (value >> 16); // value를 16비트만큼 오른쪽으로 옮긴다.
		byteArray[2] = (byte) (value >> 8);  // value를 8비트만큼 오른쪽으로 옮긴다.
		byteArray[3] = (byte) (value);       // value를 바이트로 형변환
		return byteArray;
	}

	public static String BitString(byte value) {

		StringBuffer strBuf = new StringBuffer(byteSize + 12);// 문자열 저장 버퍼

		for (int i = 0; i < byteSize; i++) {// byte 비트수 만큼 비교
			int m = value >> (byteSize - i - 1);// 맨 최상위 비트부터 버퍼에 넣는다.
			if ((m & 1) == 1) {// 비트를 비교해서 모두 1인 경우에만 1이 된다
				// System.out.print("1");
				strBuf.append("1");
			} else {
				// System.out.print("0");
				strBuf.append("0");
			}
			if (((i + 1) % 4) == 0) {// 4의 배수
				if (((i + 1) % 8) == 0 && ((i + 1) != byteSize)) {// 8의 배수와 끝이 아닐때
					// System.out.print(" / ");
					strBuf.append(" / ");
				} else {
					// System.out.print(" ");
					strBuf.append(" ");
				}

			}
		}
		return strBuf.toString();
	}

	public static int bytePackToInt(byte[] bValues) {
		// 바이트를 정수 배열로
		int s1 = bValues[0] & 0xFF; // 각 비트를 비교하여 둘다 1일경우에만 1이된다.
		int s2 = bValues[1] & 0xFF;
		int s3 = bValues[2] & 0xFF;
		int s4 = bValues[3] & 0xFF;

		return (s1 * (int) Math.pow(2, 24)) + (s2 * (int) Math.pow(2, 16)) + (s3 * (int) Math.pow(2, 8))
				+ (s4 * (int) Math.pow(2, 0)); //각각 비트 위치만큼 곱해주고 모두 더한다.
	}

	public static void main(String[] args) {

		int b = 1111;
		System.out.println("intToByteArray");
		System.out.println("input: " + b);
		byte[] a = intToByteArray(b);
		System.out.println("result: ");
		for (int i = 0; i < a.length; i++) {
			System.out.println(BitString(a[i]));
		}
		System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
		System.out.println("bytePackToInt ");
		System.out.println("input: ");
		byte[] aa = { (byte) 192, (byte) 168, (byte) 64, (byte) 125 };
		for (int i = 0; i < aa.length; i++) {
			System.out.println(BitString(aa[i]));
		}
		System.out.println("result: ");
		if (bytePackToInt(aa) < 0) { //정수 표현 범위를 넘으면
			double d = 4294967296d + bytePackToInt(aa); // 정수표현을 넘었으므로 정수최대치*2를 더함
			BigDecimal n1 = new BigDecimal(d); // 지수 표현 없애기
			System.out.println(n1);
		} else {
			System.out.println(bytePackToInt(aa));
		}

	}

}
