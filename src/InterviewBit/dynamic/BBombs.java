package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class BBombs {
	public static void main(String[] args) {
		BBombs bBombs = new BBombs();
		System.out.println(bBombs.solve(11, new ArrayList<Integer>(Arrays.asList(8, 22))));
	}

	public ArrayList<Integer> solve(int a, ArrayList<Integer> b) {
		if (b.size() == 0) {
			return null;
		}

		int min = 0;

		for (int i = 0; i < b.size(); i++) {
			if (b.get(min) > b.get(i)) {
				min = i;
			}
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		int size = a / b.get(min);
		while (size > 0) {
			sol.add(min);
			size--;
		}
		int sum = sol.size() * b.get(min);
		for (int i = 0; i < sol.size(); i++) {
			for (int j = 0; j < min; j++) {
				if (a - (sum - b.get(min) + b.get(j)) >= 0) {
					sol.set(i, j);
					sum = sum - b.get(min) + b.get(j);
					break;
				}
			}
		}

		return sol;

	}

	public ArrayList<Integer> solve1(int a, ArrayList<Integer> b) {
		ArrayList<Integer> sol = new ArrayList<Integer>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		sol(a, b, 0, temp, sol);

		return sol;
	}

	private void sol(int a, ArrayList<Integer> b, int i, ArrayList<Integer> temp, ArrayList<Integer> sol) {
		if (a == 0) {
			if (sol.size() == 0) {
				sol.addAll(temp);
			} else if (sol.size() < temp.size()) {
				sol.removeAll(sol);
				sol.addAll(temp);

			}
		}
		if (a > 0 && i < b.size()) {
			temp.add(i);
			sol(a - b.get(i), b, i, temp, sol);

			sol(a - b.get(i), b, i + 1, temp, sol);

			temp.remove(temp.size() - 1);

			sol(a, b, i + 1, temp, sol);

		}

	}
}
