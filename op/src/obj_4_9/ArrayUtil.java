package obj_4_9;

public class ArrayUtil {
	public static int[] concat(int[] a, int[] b) {

		int n = a.length + b.length;
		int[] temp = new int[n]; // 배열 두개의 원소를 넣을 배열 생성

		for (int k = 0; k < n; k++) { // 배열 두개의 원소를 합친다.
			if (k < a.length) { // a배열 넣기
				temp[k] = a[k];
			} else { // b배열 넣기
				temp[k] = b[k - a.length];
			}
		}
		
		System.out.print("Array Concat result: ["); //합친 배열을 출력
		for (int i = 0; i < temp.length; i++) {
			System.out.print(temp[i]);
			if(i != temp.length-1) { //마지막만빼고 ,넣기
				System.out.print(", ");
			}
		}
		System.out.print("]\n");

		Ascending(temp); // 오름차순 정렬

		return temp;
	}
	
	public static int[] Ascending(int[] arr) {
		//라이브러리 쓰지 않고 직접 정렬
		int temp;
		
		//버블 정렬 구현
		for(int i =0;i<arr.length;i++) {
			for(int j = 0 ; j<arr.length-1-i;j++) {
				if(arr[j] > arr[j+1]) { // 앞의 숫자가 뒤의 숫자보다 크다면 
					temp = arr[j];      //위치를바꾼다
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		return arr;
	}

	public static void print(int[] a) {
		// 배열 출력
		System.out.print("Ascending order: [");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if(i != a.length-1) {//마지막만빼고 ,넣기
				System.out.print(", ");
			}
		}
		System.out.print("]");

	}

}
