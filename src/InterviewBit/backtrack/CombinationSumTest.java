package InterviewBit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CombinationSumTest {
	public static void main(String[] args) {
		CombinationSumTest combinationSum = new CombinationSumTest();
		for (ArrayList<Integer> inner : combinationSum
				// .combinationSum(new ArrayList<Integer>(Arrays.asList(8, 10,
				// 6, 11, 1, 16, 8)), 28)) {
				.combinationSum(new ArrayList<Integer>(Arrays.asList(1, 1, 1, 3)), 3)) {
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

	private boolean findSol(int i, ArrayList<Integer> a, int b, ArrayList<ArrayList<Integer>> sol,
			ArrayList<Integer> temp) {
		boolean ret = false;
		if (b < 0) {
			return false;
		} else if (i > a.size()) {
			return false;
		} else if (b == 0) {
			sol.add(new ArrayList<Integer>(temp));
			return true;
		} else {
			for (int j = i; j < a.size(); j++) {
				if (j != i && a.get(j) == a.get(j - 1))
					continue;
				temp.add(a.get(j));
				findSol(j + 1, a, b - a.get(j), sol, temp);
				temp.remove(temp.size() - 1);

			}
		}

		return ret;
	}

}
