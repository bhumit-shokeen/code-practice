package InterviewBit.array.binary_serach;

import java.util.Arrays;
import java.util.List;

public class KSmallestElement {
	public static void main(String[] args) {
		KSmallestElement kSmallestElement = new KSmallestElement();
		System.out.println(kSmallestElement.kthsmallest(Arrays.asList(2, 1, 4, 3, 2), 3));
	}

	public int kthsmallest(final List<Integer> a, int k) {
		int mid = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		int temp;
		for (int i = 0; i < a.size(); i++) {
			temp = a.get(i);
			if (temp < min) {
				min = temp;
			}
			if (temp > max) {
				max = temp;
			}
		}

		while (min < max) {
			mid = (min + max) / 2;
			if (findLessEqual(a, mid) < k) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}
		return min;
	}

	private int findLessEqual(List<Integer> a, int mid) {
		int count = 0;
		for (Integer val : a) {
			if (val <= mid) {
				count++;
			}
		}
		return count;
	}
}
