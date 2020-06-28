package test;

interface Area1 {
	void calc();
}

interface Volume1 {
	void calc();
}

public class SameMethodNameEx1 implements Volume1, Area1 {
	public static void main(String[] args) {

		SameMethodNameEx1 same = new SameMethodNameEx1();
		same.calc();
		Area1 same_area = new SameMethodNameEx1();
		same_area.calc();
		Volume1 same_volume = new SameMethodNameEx1();
		same_volume.calc();
	}

	@Override
	public void calc() {
		System.out.println("???");
		
	}
}