package InterviewBit.hash_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class FourSum {
	public static void main(String[] args) {
		FourSum fourSum = new FourSum();
		for (ArrayList<Integer> inner : fourSum.fourSum(new ArrayList<Integer>(Arrays.asList(9, -8, -10, -7, 7, -8, 2,
				-7, 4, 7, 0, -3, -4, -5, -1, -4, 5, 8, 1, 9, -2, 5, 10, -5, -7, -1, -6, 4, 1, -5, 3, 8, -4, -10, -9, -3,
				10, 0, 7, 9, -8, 10, -9, 7, 8, 0, 6, -6, -7, 6, -4, 2, 0, 10, 1, -2, 5, -2)), 0)) {
			System.out.println("");
			for (Integer integer : inner) {
				System.out.print(integer);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> a, int b) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner = null;
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		Collections.sort(a);
		int l, r, target;
		for (int i = 0; i < a.size() - 3; i++) {
			for (int j = i + 1; j < a.size() - 2; j++) {
				target = b - a.get(i) - a.get(j);
				l = j + 1;
				r = a.size() - 1;
				while (l < r) {
					if (target > a.get(l) + a.get(r)) {
						l++;
					} else if (target < a.get(l) + a.get(r)) {
						r--;
					} else {
						inner = new ArrayList<Integer>();
						inner.add(a.get(i));
						inner.add(a.get(j));
						inner.add(a.get(l));
						inner.add(a.get(r));
						if (!set.contains(inner)) {
							set.add(inner);
							sol.add(inner);
						}

						l++;
						r--;
					}
				}
			}

		}
		return sol;

	}

	public ArrayList<ArrayList<Integer>> fourSum1(ArrayList<Integer> a, int b) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> inner = null;
		Collections.sort(a);
		int s, e;
		for (int i = 0; i < a.size() - 3; i++) {
			inner = new ArrayList<ArrayList<Integer>>();
			s = a.get(i);
			for (int j = i + 3; j < a.size(); j++) {
				e = a.get(j);
				inner = twoSum(i, j, a, b - s - e);
				sol.addAll(inner);

			}
		}
		return sol;
	}

	private ArrayList<ArrayList<Integer>> twoSum(int i, int j, ArrayList<Integer> a, int b) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> inner = null;
		for (int l = i + 1; l < j; l++) {
			if (map.containsKey(b - a.get(l))) {
				inner = new ArrayList<Integer>();
				inner.add(a.get(i));
				inner.add(b - a.get(l));
				inner.add(a.get(l));
				inner.add(a.get(j));
				sol.add(inner);
			} else if (!map.containsKey(a.get(l))) {
				map.put(a.get(l), a.get(l));
			}

		}
		return sol;
	}
}
