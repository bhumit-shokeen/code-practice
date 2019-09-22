package InterviewBit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TempClass {
	public static void main(String[] args) {
		TempClass tempClass = new TempClass();
		for (ArrayList<Integer> inner : tempClass.combinationSum(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3)),
				3)) {

			System.out.println("");
			for (Integer integer : inner) {
				System.out.print("  " + integer);
			}

		}
	}

	public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
		Collections.sort(a);

		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		findSol(0, a, b, sol, temp);
		return sol;
	}

	private void findSol(int i, ArrayList<Integer> a, int b, ArrayList<ArrayList<Integer>> sol,
			ArrayList<Integer> temp) {
		if (b < 0 || i > a.size()) {
			return;
		}
		if (b == 0) {
			sol.add(new ArrayList<Integer>(temp));
		} else {
			for (int j = i; j < a.size(); j++) {

				if (j != i && a.get(j) == a.get(j - 1))
					continue;
				temp.add(a.get(j));

				// findSol(j, a, b - a.get(j), sol, temp);
				findSol(j + 1, a, b - a.get(j), sol, temp);
				temp.remove(temp.size() - 1);

			}
		}

	}
}
