package InterviewBit.array.binary_serach;

import java.util.Arrays;
import java.util.List;

public class RotatedSortedArray {
	public static void main(String[] args) {
		RotatedSortedArray rotatedSortedArray = new RotatedSortedArray();
		System.out.println(rotatedSortedArray.search(Arrays.asList(1, 2, 3, 4, 5, 6), 6));
		System.out.println(rotatedSortedArray.search(Arrays.asList(4, 5, 6, 1, 2, 3), 6));
		System.out.println(rotatedSortedArray.search(Arrays.asList(2, 3, 4, 5, 6, 1), 6));
		System.out.println(rotatedSortedArray.search(Arrays.asList(3, 4, 5, 6, 1, 2), 6));
		System.out.println(rotatedSortedArray.search(Arrays.asList(5, 6, 1, 2, 3, 4), 4));
	}

	public int search(final List<Integer> a, int b) {
		int pivot = pivot(a, 0, a.size() - 1);
		int start = 0;
		int end = pivot - 1;
		int mid;
		while (start < end) {
			mid = (start + end) / 2;
			if (a.get(mid) == b) {
				return mid;
			} else if (b < a.get(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		if (a.get(start) == b) {
			return start;
		}
		start = pivot;
		end = a.size() - 1;
		while (start < end) {
			mid = (start + end) / 2;
			if (a.get(mid) == b) {
				return mid;
			} else if (b < a.get(mid)) {
				end = mid;
			} else {
				start = mid + 1;
			}
		}
		if (a.get(start) == b) {
			return start;
		}

		return -1;
	}

	public int pivot(List<Integer> a, int start, int end) {
		if (a.get(start) < a.get(end)) {
			return start;
		}
		int s = a.size();
		int mid;
		mid = (start + end) / 2;
		if (a.get((mid - 1 % s)) > a.get(mid) && a.get((mid - 1 % s)) > a.get(mid)) {
			return mid;
		} else if (a.get(start) > a.get(mid)) {
			return pivot(a, start, mid - 1);

		} else {
			return pivot(a, mid + 1, end);
		}

	}
}
