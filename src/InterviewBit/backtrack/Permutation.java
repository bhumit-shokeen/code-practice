package InterviewBit.backtrack;

import java.util.ArrayList;
import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		Permutation name = new Permutation();
		for (ArrayList<Integer> inner : name.permute(new ArrayList<Integer>(Arrays.asList(1, 2, 3)))) {
			System.out.println("");
			for (Integer integer : inner) {
				System.out.print(" " + integer);
			}
		}

	}

	public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> a) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		findSol(0, a, temp, sol);
		return sol;
	}

	private void findSol(int i, ArrayList<Integer> a, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> sol) {
		if (i == a.size()) {
			sol.add(new ArrayList<>(temp));
		} else {
			for (int j = 0; j < a.size(); j++) {
				if (!temp.contains(a.get(j))) {
					temp.add(a.get(j));
					findSol(i + 1, a, temp, sol);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}
}
