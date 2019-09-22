package InterviewBit.backtrack;

import java.util.ArrayList;

public class NQueens {
	public static void main(String[] args) {
		NQueens nQueens = new NQueens();
		nQueens.solveNQueens(4);
	}

	public ArrayList<ArrayList<String>> solveNQueens(int a) {
		ArrayList<ArrayList<String>> sol = new ArrayList<ArrayList<String>>();
		int[] temp = new int[a];
		findSol(0, a, temp, sol);

		for (ArrayList<String> eachMat : sol) {
			System.out.println("");
			System.out.println("");
			for (String cs : eachMat) {
				System.out.println(cs);
			}
		}

		return sol;
	}

	private void findSol(int current, int a, int[] temp, ArrayList<ArrayList<String>> sol) {
		if (current == a) {
			ArrayList<String> tempAdd = new ArrayList<String>();
			StringBuffer s = null;
			for (int i = 0; i < a; i++) {
				s = new StringBuffer();
				for (int j = 0; j < a; j++) {
					if (temp[i] == j) {
						s.append('Q');
					} else {
						s.append('.');
					}
				}
				tempAdd.add(s.toString());

			}
			sol.add(tempAdd);
		} else {
			for (int i = 0; i < a; i++) {
				if (isPossible(i, current, temp)) {
					temp[current] = i;
					findSol(current + 1, a, temp, sol);
				}
			}
		}
	}

	private boolean isPossible(int i, int current, int[] temp) {
		if (current == 0)
			return true;
		for (int j = 0; j < current; j++) {
			if (temp[j] == i || temp[j] - i == j - current || temp[j] - i == current - j) {
				return false;
			}
		}
		return true;
	}

}
