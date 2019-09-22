package InterviewBit.array.binary_serach;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixSearch {
	public static void main(String[] args) {
		MatrixSearch matrixSearch = new MatrixSearch();
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		a.add(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 7)));
		a.add(new ArrayList<Integer>(Arrays.asList(10, 11, 16, 20)));
		a.add(new ArrayList<Integer>(Arrays.asList(23, 30, 34, 50)));

		System.out.println(matrixSearch.searchMatrix(a, 52));
	}

	public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
		int low = 0;
		int high = a.size() - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (a.get(mid).get(0) == b) {
				return 1;
			} else if (a.get(mid).get(0) < b) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		int mid2 = 0;
		mid = low;
		low = 0;
		high = a.get(0).size() - 1;
		while (low < high) {
			mid2 = (low + high) / 2;
			if (a.get(mid).get(mid2) == b) {
				return 1;
			} else if (a.get(mid).get(mid2) < b) {
				low = mid2 + 1;
			} else {
				high = mid2 - 1;
			}
		}
		if (a.get(mid).get(low) == b) {
			return 1;
		} else if (mid != 0)
			mid = mid - 1;
		low = 0;
		high = a.get(0).size() - 1;
		while (low < high) {
			mid2 = (low + high) / 2;
			if (a.get(mid).get(mid2) == b) {
				return 1;
			} else if (a.get(mid).get(mid2) < b) {
				low = mid2 + 1;
			} else {
				high = mid2 - 1;
			}
		}
		if (a.get(mid).get(low) == b) {
			return 1;
		} else
			return 0;

	}
}
