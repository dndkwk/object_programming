package obj_4_9;

public class staticEx {

	public static void main(String[] args) {
		int[] array1 = { 1, 5, 7, 9 };
		int[] array2 = { 3, 6, -1, 100, 77 };
		int[] array3 = ArrayUtil.concat(array1, array2); // �迭 ��ġ�� ����
		ArrayUtil.print(array3); // �迭 ���

	}

}
