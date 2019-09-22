package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SubMatZeroSum {
	public static void main(String[] args) {
		SubMatZeroSum subMatZeroSum = new SubMatZeroSum();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();

		input.add(new ArrayList(Arrays.asList(-1, 1, -1, 1)));
		// input.add(new ArrayList(Arrays.asList(-1, 1, -1, 1)));
		// input.add(new ArrayList(Arrays.asList(1, -1, 1, -1)));
		// input.add(new ArrayList(Arrays.asList(0, 0, 0, 0)));
		// input.add(new ArrayList(Arrays.asList(0, 0, 0)));

		System.out.println(subMatZeroSum.solve(input));
	}

	public int solve(ArrayList<ArrayList<Integer>> a) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		int sol = 0;
		for (int i = 0; i < a.size(); i++) {
			list.clear();
			for (int j = i; j < a.size(); j++) {
				for (int k = 0; k < a.get(0).size(); k++) {
					if (i == j) {
						list.add(a.get(j).get(k));
					} else {
						list.set(k, list.get(k) + a.get(j).get(k));
					}

				}
				sol += count(list);
			}

		}

		return sol;
	}

	private int count(ArrayList<Integer> a) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);
		int sol = 0;
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum += a.get(i);
			if (map.containsKey(sum)) {
				sol += map.get(sum);
				map.put(sum, map.get(sum) + 1);
			} else {
				map.put(sum, 1);
			}
		}
		return sol;
	}
}
