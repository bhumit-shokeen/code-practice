package two;

public class ArrayRotateBlockSwap {
	public static void main(String args[]) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int d = 7;
		int n = array.length;
		rotate(array, d - 1, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.println(array[i]);
		}

	}

	public static void rotate(int[] array, int mid, int start, int end) {

		// first direcdtion
		if (mid - start < end - mid - 1) {
			swap(array, mid - start + 1, start, end);
			rotate(array, mid, start, end - mid + start - 1);

		}
		// Second direction
		else if (mid - start > end - mid - 1) {
			swap(array, end - mid, start, end);
			rotate(array, mid, start + end - mid, end);
		}
		// start+d == end-d+1
		else {
			swap(array, mid - start + 1, start, end);
		}

	}

	public static void swap(int[] array, int d, int start, int end) {
		int temp;
		int i = 0;
		end = end - d + 1;
		while (i < d) {
			temp = array[start + i];
			array[start + i] = array[end + i];
			array[end + i] = temp;
			i++;
		}

	}
}
