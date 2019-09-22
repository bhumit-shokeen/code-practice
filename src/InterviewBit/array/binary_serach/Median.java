package InterviewBit.array.binary_serach;

public class Median {

	public static void main(String[] args) {
		Median median = new Median();
		System.out.println(median.findMedianSortedArrays(new int[] { 1, 3 }, new int[] { 2 }));
	}

	public double findMedianSortedArrays(int[] a, int[] b) {
		int x = a.length;
		int y = b.length;
		if (x > y) {
			return findMedianSortedArrays(b, a);
		}
		int low = 0;
		int high = x;
		int px;
		int py;
		int minRightX = 0, maxLeftX = 0, minRightY = 0, maxLeftY = 0;
		while (low <= high) {
			px = (low + high) / 2;
			// this is trick again
			py = (x + y + 1) / 2 - px;
			// again trick
			maxLeftX = px == 0 ? Integer.MIN_VALUE : a[px - 1];
			minRightX = px == x ? Integer.MAX_VALUE : a[px];
			maxLeftY = py == 0 ? Integer.MIN_VALUE : b[py - 1];
			minRightY = py == y ? Integer.MAX_VALUE : b[py];

			if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
				break;
			} else if (maxLeftX > minRightY) {
				high = px - 1;
			} else {
				// again trick
				low = px + 1;
			}

		}
		if (x + y % 2 == 0) {
			return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
		}
		return Math.max(maxLeftX, maxLeftY);
	}
}
