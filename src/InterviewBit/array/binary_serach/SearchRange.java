package InterviewBit.array.binary_serach;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {
	public static void main(String[] args) {
		SearchRange searchRange = new SearchRange();
		System.out.println(searchRange.searchRange(Arrays.asList(5, 7, 7, 8, 8, 10), 5));

	}

	public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
		int low = 0;
		int high = a.size() - 1;
		int mid = 0;
		while (low < high) {
			mid = (low + high) / 2;
			if (b <= a.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		if (b != a.get(low)) {
			return new ArrayList<Integer>(Arrays.asList(-1, -1));
		}
		int l = low;
		low = 0;
		high = a.size() - 1;
		while (low < high) {
			mid = (low + high) / 2;
			if (b < a.get(mid)) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		if (b != a.get(low)) {
			return new ArrayList<Integer>(Arrays.asList(l, low - 1));
		}
		return new ArrayList<Integer>(Arrays.asList(l, low));
	}

	public ArrayList<Integer> searchRange1(final List<Integer> a, int b) {
		int low = 0;
		int high = a.size() - 1;
		int mid = 0;
		while (low <= high) {
			mid = (low + high) / 2;
			if (b == a.get(mid)) {
				break;
			} else if (b < a.get(mid)) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (b != a.get(mid)) {
			return new ArrayList<Integer>(Arrays.asList(-1, -1));
		}
		int i = mid;
		int h = -1;
		int l = -1;
		while (i < a.size() && b == a.get(i)) {
			h = i;
			i++;
		}
		i = mid;
		while (i >= 0 && b == a.get(i)) {
			l = i;
			i--;
		}
		return new ArrayList<Integer>(Arrays.asList(l, h));
	}
}
