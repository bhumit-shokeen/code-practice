package InterviewBit.array.binary_serach;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooks {

	public static void main(String[] args) {
		AllocateBooks allocateBooks = new AllocateBooks();
		System.out.println(allocateBooks.books(new ArrayList<Integer>(Arrays.asList(97, 26, 12, 67, 10, 33, 79, 49, 79,
				21, 67, 72, 93, 36, 85, 45, 28, 91, 94, 57, 1, 53, 8, 44, 68, 90, 24)), 26));
	}

	public int books(ArrayList<Integer> A, int B) {
		if (A.size() > B) {
			return -1;
		}

		int low = -1;

		int high = 0;
		for (int i = 0; i < A.size(); i++) {
			high += A.get(i);
			if (low < A.get(i)) {
				low = A.get(i);
			}
		}
		int mid;
		int k;
		while (low < high) {
			mid = (low + high) / 2;
			k = getMen(A, mid);
			if (k <= B) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}

		return high;
	}

	private int getMen(ArrayList<Integer> a, int mid) {
		int total = 0;
		int men = 1;
		for (int i = 0; i < a.size(); i++) {
			total += a.get(i);
			if (total > mid) {
				men++;
				total = a.get(i);
			}
		}
		return men;
	}
}
