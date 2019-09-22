//http://www.geeksforgeeks.org/sort-array-wave-form-2
package two;

public class ArrayWaveForm {

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 5, 6 };
		wave(array);
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
	}

	private static void wave(int[] array) {
		for (int i = 0; i < array.length; i = i + 2) {
			int temp;
			if (i > 0) {
				if (array[i] < array[i - 1]) {
					temp = array[i - 1];
					array[i - 1] = array[i];
					array[i] = temp;
				}
			}
			if (i < array.length) {
				if (array[i] < array[i + 1]) {
					temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;

				}

			}
		}

	}
}
