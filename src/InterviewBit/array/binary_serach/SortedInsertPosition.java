package InterviewBit.array.binary_serach;

import java.util.ArrayList;
import java.util.Arrays;

public class SortedInsertPosition {
	public static void main(String[] args) {
		SortedInsertPosition sortedInsertPosition = new SortedInsertPosition();
		System.out.println(sortedInsertPosition.searchInsert(new ArrayList<Integer>(Arrays.asList(1, 3, 5, 6)), 0));
	}

	public int searchInsert(ArrayList<Integer> a, int b) {
		int low = 0;
		int high = a.size() - 1;
		int mid;
		while (low < high) {
			mid = (low + high) / 2;
			if (b <= a.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		if (b <= a.get(low)) {
			return low;
		}

		return low + 1;
	}
}
