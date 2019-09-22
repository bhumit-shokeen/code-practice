package InterviewBit.bit;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxContinuousSeriesOfOne {
	public static void main(String[] args) {
		MaxContinuousSeriesOfOne maxContinuousSeriesOfOne = new MaxContinuousSeriesOfOne();

		for (Integer i : maxContinuousSeriesOfOne.maxone(new ArrayList<Integer>(Arrays.asList(1, 1, 0)), 7)) {
			System.out.println(i);
		}

	}

	public ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

		int s = 0, e = 0, as = 0, ae = 0;
		int counter = b;
		int current;
		for (int i = 0; i < a.size() && counter > 0; i++) {
			if (a.get(i) == 0) {
				counter--;
			}
			e++;
		}
		if (e == a.size()) {
			as = 0;
			ae = e - 1;
		} else {
			as = 0;
			if (b <= 0)
				ae = e;
			ae = e - 1;

			for (; e < a.size(); e++) {
				if (a.get(e) == 0) {
					while (a.get(s) == 1) {
						s++;
					}
					if (a.get(s) == 0) {
						s++;
						if (b > 0)
							counter++;
					}

				}
				if (ae - as < e - s) {
					ae = e;
					as = s;
				}
			}
		}

		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i = as; i <= ae; i++) {
			sol.add(i);
		}

		return sol;
	}

	private ArrayList<Integer> findOne(ArrayList<Integer> a) {

		int as = 0;
		int ae = 0;
		int s = 0;
		int e = 0;
		int maxLen = 0;
		int current;
		int i;
		int j;
		if (!a.contains(0)) {
			ae = a.size() - 1;
		} else if (a.contains(1)) {
			for (i = 0; i < a.size(); i++) {
				current = a.get(i);
				if (current == 0) {

					j = i - 1;
					while (j >= 0 && a.get(j) == 1) {
						j--;
					}
					if (j < 0) {
						s = 0;
						e = i;
						if (maxLen < e - s) {
							maxLen = e - s;
							as = s;
							ae = e - 1;
						}
					} else {
						e = i;
						s = j + 1;
						if (maxLen < e - s) {
							maxLen = e - s;
							as = s;
							ae = e;
						}

					}
				}
			}
			i--;
			while (i >= 0) {
				if (a.get(i) == 0) {
					e = a.size() - 1;
					s = i;
					if (maxLen < e - s) {
						maxLen = e - s;
						as = s + 1;
						ae = e;
					}
					break;
				}
				i--;
			}
		}

		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (i = as; i <= ae; i++) {
			sol.add(i);
		}

		return sol;
	}
}
