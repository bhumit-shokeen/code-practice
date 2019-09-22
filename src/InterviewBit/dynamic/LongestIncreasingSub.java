package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSub {
	public static void main(String[] args) {
		LongestIncreasingSub increasingSub = new LongestIncreasingSub();
		ArrayList<Integer> input = new ArrayList<Integer>(Arrays.asList(1, 11, 2, 10, 4, 5, 2, 1));
		System.out.println(increasingSub.longestSubsequenceLength(input));
	}

	public int longestSubsequenceLength(final List<Integer> a) {
		if (a.isEmpty()) {
			return 0;
		}
		ArrayList<Integer> lis = lism(a);
		ArrayList<Integer> lds = ldsm(a);
		int sol = 0;
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum = lis.get(i) + lds.get(i);
			if (sum > sol) {
				sol = sum;
			}
		}

		return sol - 1;
	}

	public ArrayList<Integer> lism(List<Integer> a) {
		ArrayList<Integer> mem = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			mem.add(1);
		}
		int sol = 1;
		for (int i = 1; i < a.size(); i++) {
			int j = i;
			for (int k = i - 1; k >= 0; k--) {
				if (a.get(k) < a.get(i) && mem.get(k) >= mem.get(j)) {
					j = k;
				}
			}
			if (j != i) {
				mem.set(i, mem.get(j) + 1);
			}
			if (sol < mem.get(i)) {
				sol = mem.get(i);
			}
		}
		return mem;

	}

	public ArrayList<Integer> ldsm(List<Integer> a) {
		ArrayList<Integer> mem = new ArrayList<>();
		for (int i = 0; i < a.size(); i++) {
			mem.add(1);
		}
		int sol = 1;
		for (int i = a.size() - 2; i >= 0; i--) {
			int j = i;
			for (int k = i + 1; k < a.size(); k++) {
				if (a.get(k) < a.get(i) && mem.get(k) >= mem.get(j)) {
					j = k;
				}
			}
			if (j != i) {
				mem.set(i, mem.get(j) + 1);
			}
			if (sol < mem.get(i)) {
				sol = mem.get(i);
			}
		}
		return mem;

	}
}
