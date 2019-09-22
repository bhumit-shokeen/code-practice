package InterviewBit.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MatrixMedian {
	public static void main(String[] args) {
		MatrixMedian matrixMedian = new MatrixMedian();
		ArrayList<ArrayList<Integer>> A = new ArrayList<ArrayList<Integer>>();
		A.add(new ArrayList<Integer>(Arrays.asList(1, 3, 6)));
		A.add(new ArrayList<Integer>(Arrays.asList(2, 6, 9)));
		A.add(new ArrayList<Integer>(Arrays.asList(3, 6, 9)));
		System.out.println(matrixMedian.findMedian(A));

		int r = 3, c = 3;
		int m[][] = { { 1, 3, 6 }, { 2, 6, 9 }, { 3, 6, 9 } };

		System.out.println("Median is " + matrixMedian.findMedian3(m, r, c));
	}

	public int findMedian(ArrayList<ArrayList<Integer>> a) {
		int min = a.get(0).get(0);
		int max = a.get(0).get(a.get(0).size() - 1);
		int desired = a.size() * a.get(0).size() / 2 + 1;

		for (int i = 1; i < a.size(); i++) {

			if (a.get(i).get(0) < min) {
				min = a.get(i).get(0);
			}
			if (a.get(i).get(a.get(i).size() - 1) > max) {
				max = a.get(i).get(a.get(i).size() - 1);
			}

		}
		int get;
		int sol = 0;
		int mid;
		while (min < max) {
			sol = 0;
			mid = (min + max) / 2;
			// for getting elements smaller than equal to mid
			for (int i = 0; i < a.size(); i++) {
				get = Collections.binarySearch(a.get(i), mid);
				if (get < 0) {
					get = (-1) * get - 1;
				} else {
					while (get < a.get(i).size() && a.get(i).get(get) == mid) {
						get++;
					}
				}
				sol += get;
			}
			if (sol < desired) {
				min = mid + 1;
			} else {
				max = mid;
			}
		}

		return min;
	}

	public int findMedian2(ArrayList<ArrayList<Integer>> a) {
		int min, index;
		int size = a.size() * a.get(0).size();
		for (int i = 0; i <= size / 2; i++) {
			min = Integer.MAX_VALUE;
			index = -1;
			for (int j = 0; j < a.size(); j++) {
				if (!a.get(j).isEmpty() && a.get(j).get(0) < min) {
					min = a.get(j).get(0);
					index = j;
				}
			}
			if (i == size / 2) {
				return a.get(index).get(0);
			}
			a.get(index).remove(0);
		}

		return 0;
	}

	int findMedian3(int m[][], int r, int c) {
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < r; i++) {

			// Finding the minimum element
			if (m[i][0] < min)
				min = m[i][0];

			// Finding the maximum element
			if (m[i][c - 1] > max)
				max = m[i][c - 1];
		}

		int desired = (r * c + 1) / 2;
		while (min < max) {
			int mid = min + (max - min) / 2;
			int place = 0;
			int get = 0;

			// Find count of elements smaller than mid
			for (int i = 0; i < r; ++i) {

				get = Arrays.binarySearch(m[i], mid);

				// If element is not found in the array the
				// binarySearch() method returns
				// (-(insertion_point) - 1). So once we know
				// the insertion point we can find elements
				// Smaller than the searched element by the
				// following calculation
				if (get < 0)
					get = Math.abs(get) - 1;

				// If element is found in the array it returns
				// the index(any index in case of duplicate). So we go to last
				// index of element which will give the number of
				// elements smaller than the number including
				// the searched element.
				else {
					while (get < m[i].length && m[i][get] == mid)
						get += 1;
				}

				place = place + get;
			}

			if (place < desired)
				min = mid + 1;
			else
				max = mid;
		}
		return min;
	}
}
