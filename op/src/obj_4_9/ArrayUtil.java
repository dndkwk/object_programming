package obj_4_9;

public class ArrayUtil {
	public static int[] concat(int[] a, int[] b) {

		int n = a.length + b.length;
		int[] temp = new int[n]; // �迭 �ΰ��� ���Ҹ� ���� �迭 ����

		for (int k = 0; k < n; k++) { // �迭 �ΰ��� ���Ҹ� ��ģ��.
			if (k < a.length) { // a�迭 �ֱ�
				temp[k] = a[k];
			} else { // b�迭 �ֱ�
				temp[k] = b[k - a.length];
			}
		}
		
		System.out.print("Array Concat result: ["); //��ģ �迭�� ���
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
			if(i != temp.length-1) { //������������ ,�ֱ�
				System.out.print(", ");
			}
		}
		System.out.print("]\n");

		Ascending(temp); // �������� ����

		return temp;
	}
	
	public static int[] Ascending(int[] arr) {
		//���̺귯�� ���� �ʰ� ���� ����
		int temp;
		
		//���� ���� ����
		for(int i =0;i<arr.length;i++) {
			for(int j = 0 ; j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) { // ���� ���ڰ� ���� ���ں��� ũ�ٸ� 
					temp = arr[j];      //��ġ���ٲ۴�
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

	public static void print(int[] a) {
		// �迭 ���
		System.out.print("Ascending order: [");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i != a.length-1) {//������������ ,�ֱ�
				System.out.print(", ");
			}
		}
		System.out.print("]");

	}

}
