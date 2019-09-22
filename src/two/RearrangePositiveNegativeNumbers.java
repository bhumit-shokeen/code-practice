//http://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
package two;

public class RearrangePositiveNegativeNumbers {
	public static void main(String[] args) {

		int[] array = new int[] { -12, 11, -13, -5, 6, -3, 3, -44, 6 };
		arrange(array, 0, array.length - 1);
		// arrange2(array);
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
	}

	private static void arrange2(int[] array) {
		int temp = 0;
		int prev = 0;
		int j = 0;
		for (int i = 0; i < array.length && j < array.length; i++) {
			if (array[i] >= 0) {
				temp = array[i];
				for (j = i + 1; j < array.length && temp >= 0; j++) {
					prev = array[j];
					array[j] = temp;
					temp = prev;

				}

				if (temp < 0) {
					array[i] = temp;

				}

			}
		}

	}

	private static void arrange(int[] array, int s, int e) {
		if (s == e) {
			return;
		}
		int mid = (s + e) / 2;

		arrange(array, s, mid);
		arrange(array, mid + 1 <= e ? mid + 1 : e, e);
		merge(array, s, mid, e);

	}

	private static void merge(int[] array, int s, int mid, int e) {

		int rp = -1, ln = -1;
		for (int i = s; i <= mid; i++) {
			if (array[i] >= 0) {
				rp = i;
				break;
			}
		}

		for (int i = e; i > mid; i--) {
			if (array[i] < 0) {
				ln = i;
				break;
			}
		}

		if (ln != -1 && rp != -1) {
			swap(array, rp, mid);
			swap(array, mid + 1, ln);
			swap(array, rp, ln);

		}

	}

	private static void swap(int[] array, int s, int e) {
		int temp;
		for (int i = 0; i <= ((e - s) / 2); i++) {
			temp = array[s + i];
			array[s + i] = array[e - i];
			array[e - i] = temp;
		}

	}
}
