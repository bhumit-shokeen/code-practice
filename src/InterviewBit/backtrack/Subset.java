package InterviewBit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Subset {
	public static void main(String[] args) {
		Subset subset = new Subset();
		for (ArrayList<Integer> inner : subset.subsetsWithDup(new ArrayList<Integer>(Arrays.asList(1, 2, 2)))) {
			System.out.println(" ");
			for (Integer integer : inner) {
				System.out.print(" " + integer);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		sol.add(new ArrayList());
		ArrayList<Integer> temp = new ArrayList();
		Collections.sort(a);
		findSubset(0, a, sol, temp);
		return sol;
	}

	private void findSubset(int i, ArrayList<Integer> a, ArrayList<ArrayList<Integer>> sol, ArrayList<Integer> temp) {
		if (i == a.size()) {
			return;
		} else {
			for (int j = i; j < a.size(); j++) {
				if (j != i && a.get(j) == a.get(j - 1)) {
					continue;
				}
				temp.add(a.get(j));
				sol.add(new ArrayList<Integer>(temp));
				findSubset(j + 1, a, sol, temp);
				temp.remove(temp.size() - 1);
			}
		}

	}
}
