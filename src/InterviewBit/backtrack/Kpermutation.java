package InterviewBit.backtrack;

import java.util.ArrayList;

public class Kpermutation {
	public static void main(String[] args) {
		Kpermutation kpermutation = new Kpermutation();
		System.out.println(kpermutation.getPermutation(4, 16));
	}

	static ArrayList<Integer> fact = new ArrayList<Integer>();

	Kpermutation() {
		fact.add(1);
		fact.add(1);
		Integer pre = 1;
		for (int i = 2; i <= 12; i++) {
			fact.add(pre * i);
			pre = pre * i;
		}

	}

	private int fact(int n) {
		if (n > 12)
			return Integer.MAX_VALUE;
		return fact.get(n);
	}

	public String getPermutation(int n, int k) {

		StringBuffer sol = new StringBuffer();
		ArrayList<Integer> list = new ArrayList<Integer>();
		findSol(0, n, k, list, sol);
		return sol.toString();
	}

	private void findSol(int wc, int n, int k, ArrayList<Integer> list, StringBuffer sol) {
		if (wc == k) {
			for (int i = 1; i <= n; i++) {
				if (!list.contains(i)) {
					sol.append(i);
				}

			}
		} else {
			for (int i = 1; i <= n; i++) {
				if (!list.contains(i)) {
					if (wc + fact(n - list.size() - 1) < k) {
						wc += fact(n - list.size() - 1);
					} else {
						list.add(i);
						sol.append(i);
						findSol(wc, n, k, list, sol);
						break;
					}
				}
			}
		}

	}
}
