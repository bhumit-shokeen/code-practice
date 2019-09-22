package InterviewBit.array;

public class KSmallest {
	public static void main(String[] args) {
		KSmallest kSmallest = new KSmallest();
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 1));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 2));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 3));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 4));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 5));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 6));
		System.out.println(kSmallest.quick(new int[] { 9, 5, 1, 11, 16, 2, 3 }, 0, 6, 7));
	}

	public int quick(int[] a, int l, int r, int k) {
		int random = r + (int) Math.random() * (r - l);
		swap(a, random, r);
		int part = partition(a, l, r);
		if (part == k - 1) {
			return a[part];
		} else if (k - 1 > part) {
			return quick(a, part + 1, r, k);
		} else {
			return quick(a, l, part - 1, k);
		}

	}

	private int partition(int[] a, int l, int r) {
		int x = a[r];
		int i = l;
		for (int j = l; j <= r - 1; j++) {
			if (a[j] <= x) {
				swap(a, i, j);
				i++;
			}
		}
		swap(a, i, r);
		return i;
	}

	private void swap(int[] a, int i, int r) {
		int temp = a[i];
		a[i] = a[r];
		a[r] = temp;
	}
}
