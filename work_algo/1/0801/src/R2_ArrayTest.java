// 교재 30 페이지
public class R2_ArrayTest {

	static int[] arr = { 10, 20, 30 };

	private static void printArray1() {
		for (int i = 0; i < arr.length; ++i) {
			System.out.print(arr[i] + "\t");
		}
		System.out.println();
	}

	private static void printArray1(int i) {
		if (i == arr.length) {
			System.out.println();
			return;
		}
		System.out.print(arr[i] + "\t");
		printArray1(i + 1);
	}

	public static void main(String[] args) {
		printArray1();
		System.out.println("=========================");
		printArray1(0);
	}

}
