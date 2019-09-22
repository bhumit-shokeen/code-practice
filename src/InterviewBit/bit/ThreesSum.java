package InterviewBit.bit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ThreesSum {
	public static void main(String[] args) {
		ThreesSum threeSum = new ThreesSum();
		/*
		 * System.out .println(threeSum .threeSumClosest( new
		 * ArrayList<Integer>(Arrays.asList(-5, 1, 4, -7, 10, -7, 0, 7, 3, 0,
		 * -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9, 5, 3,
		 * -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9,
		 * -2, 7, 0, -4, -3, 1, 6, -3)), -1));
		 */
		System.out.println(
				threeSum.threeSumClosest(new ArrayList<Integer>(Arrays.asList(7, 2, -5, 10, -3, 4, 9, 1, -6, -10)), 2));

	}

	public int threeSumClosest(ArrayList<Integer> a, int b) {
		Collections.sort(a);
		int i = 0;
		int j = a.size() - 1;
		int k;
		int nl;
		int nr;
		int sum = a.get(0) + a.get(j);
		if (sum < b) {
			k = j - 1;
			sum = sum + a.get(k);
			nl = i + 1;
			nr = k - 1;
		} else {
			k = i = 1;
			sum = sum + a.get(k);
			nl = k = 1;
			nr = j - 1;
		}
		int ans = sum;
		while (nl <= nr) {

			if (sum < b) {
				i = k;
				k = nr;
				nr--;
				sum = a.get(i) + a.get(j) + a.get(k);
			} else {
				j = k;
				k = nl;
				nl++;
				sum = a.get(i) + a.get(j) + a.get(k);

			}
			if ((sum - b < 0 ? -1 * (sum - b) : sum - b) < (ans - b < 0 ? -1 * (ans - b) : ans - b)) {
				ans = sum;
			}

		}

		return ans;
	}
}
