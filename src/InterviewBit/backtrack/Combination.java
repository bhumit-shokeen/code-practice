package InterviewBit.backtrack;

import java.util.ArrayList;

public class Combination {
	public static void main(String[] args) {
		Combination combination = new Combination();
		for (ArrayList<String> inner : combination.partition("efe")) {
			System.out.println("");
			for (String integer : inner) {
				System.out.print(" " + integer);
			}
		}
	}

	public ArrayList<ArrayList<Integer>> combine(int A, int B) {
		ArrayList<ArrayList<Integer>> sol;
		sol = findSol(1, A, B);
		return sol;
	}

	private ArrayList<ArrayList<Integer>> findSol(int start, int end, int b) {
		ArrayList<ArrayList<Integer>> sol = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> temp;
		if (b == 0) {
			sol.add(new ArrayList<Integer>());
		} else if (start > end) {
			sol.add(new ArrayList<Integer>());
		} else {
			for (int i = start; i <= end - b + 1; i++) {
				temp = findSol(i + 1, end, b - 1);
				for (ArrayList<Integer> list : temp) {
					list.add(0, i);

				}
				sol.addAll(temp);

			}
		}
		return sol;

	}

	ArrayList<ArrayList<String>> sol;

	public ArrayList<ArrayList<String>> partition(String a) {
		sol = new ArrayList<ArrayList<String>>();
		find(a, 0, a.length(), new ArrayList<String>());
		return sol;
	}

	private void find(String a, int s, int e, ArrayList<String> temp) {
		if (s == e) {
			sol.add(new ArrayList<String>(temp));
			return;
		}
		String palin;
		for (int i = 1; s + i <= e; i++) {
			palin = a.substring(s, s + i);
			if (isPalin(palin)) {
				temp.add(palin);
				find(a, s + i, e, temp);
				temp.remove(temp.size() - 1);

			}

		}
	}

	private boolean isPalin(String a) {
		int s = 0;
		int e = a.length() - 1;
		while (s < e) {
			if (a.charAt(s) != a.charAt(e)) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}
