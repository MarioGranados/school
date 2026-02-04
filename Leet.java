	public class Leet {
	public static void main(String[] args) {
		System.out.println("Hello, Leet!");

		String str = "Hello, Leet!";

		// print characters correctly
		for (char c : str.toCharArray()) {
			System.out.print(c);
		}
		System.out.println();

    
		// demo of simple sort
		int[] arr = {5, 2, 9, 1, 5, 6};
		System.out.print("Before: ");
		printArray(arr);

		simpleSort(arr);

		System.out.print("After:  ");
		printArray(arr);
	}

	// Simple selection sort (ascending)
	public static void simpleSort(int[] a) {
		if (a == null) return;
		int n = a.length;
		for (int i = 0; i < n - 1; i++) {
			int minIdx = i;
			for (int j = i + 1; j < n; j++) {
				if (a[j] < a[minIdx]) {
					minIdx = j;
				}
			}
			int tmp = a[i];
			a[i] = a[minIdx];
			a[minIdx] = tmp;
		}
	}

	// Utility: print array on one line
	public static void printArray(int[] a) {
		if (a == null) {
			System.out.println("null");
			return;
		}
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]);
			if (i < a.length - 1) System.out.print(", ");
		}
		System.out.println("]");
	}
}
