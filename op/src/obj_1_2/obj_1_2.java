package obj_1_2;

import java.math.BigDecimal;

public class obj_1_2 {

	private static final int byteSize = 8;

	public static byte[] intToByteArray(int value) {
		// ������ ����Ʈ �迭��
		byte[] byteArray = new byte[4];
		byteArray[0] = (byte) (value >> 24); // value�� 24��Ʈ��ŭ ���������� �ű��.
		byteArray[1] = (byte) (value >> 16); // value�� 16��Ʈ��ŭ ���������� �ű��.
		byteArray[2] = (byte) (value >> 8);  // value�� 8��Ʈ��ŭ ���������� �ű��.
		byteArray[3] = (byte) (value);       // value�� ����Ʈ�� ����ȯ
		return byteArray;
	}

	public static String BitString(byte value) {

		StringBuffer strBuf = new StringBuffer(byteSize + 12);// ���ڿ� ���� ����

		for (int i = 0; i < byteSize; i++) {// byte ��Ʈ�� ��ŭ ��
			int m = value >> (byteSize - i - 1);// �� �ֻ��� ��Ʈ���� ���ۿ� �ִ´�.
			if ((m & 1) == 1) {// ��Ʈ�� ���ؼ� ��� 1�� ��쿡�� 1�� �ȴ�
				// System.out.print("1");
				strBuf.append("1");
			} else {
				// System.out.print("0");
				strBuf.append("0");
			}
			if (((i + 1) % 4) == 0) {// 4�� ���
				if (((i + 1) % 8) == 0 && ((i + 1) != byteSize)) {// 8�� ����� ���� �ƴҶ�
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
		// ����Ʈ�� ���� �迭��
		int s1 = bValues[0] & 0xFF; // �� ��Ʈ�� ���Ͽ� �Ѵ� 1�ϰ�쿡�� 1�̵ȴ�.
		int s2 = bValues[1] & 0xFF;
		int s3 = bValues[2] & 0xFF;
		int s4 = bValues[3] & 0xFF;

		return (s1 * (int) Math.pow(2, 24)) + (s2 * (int) Math.pow(2, 16)) + (s3 * (int) Math.pow(2, 8))
				+ (s4 * (int) Math.pow(2, 0)); //���� ��Ʈ ��ġ��ŭ �����ְ� ��� ���Ѵ�.
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
		System.out.println("�ѤѤѤѤѤѤѤѤѤѤѤѤѤѤѤ�");
		System.out.println("bytePackToInt ");
		System.out.println("input: ");
		byte[] aa = { (byte) 192, (byte) 168, (byte) 64, (byte) 125 };
		for (int i = 0; i < aa.length; i++) {
			System.out.println(BitString(aa[i]));
		}
		System.out.println("result: ");
		if (bytePackToInt(aa) < 0) { //���� ǥ�� ������ ������
			double d = 4294967296d + bytePackToInt(aa); // ����ǥ���� �Ѿ����Ƿ� �����ִ�ġ*2�� ����
			BigDecimal n1 = new BigDecimal(d); // ���� ǥ�� ���ֱ�
			System.out.println(n1);
		} else {
			System.out.println(bytePackToInt(aa));
		}

	}

}
