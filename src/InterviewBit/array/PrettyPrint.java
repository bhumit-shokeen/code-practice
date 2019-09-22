package InterviewBit.array;

import java.util.ArrayList;

public class PrettyPrint {
	public static void main(String[] arg) {
		PrettyPrint prettyPrint = new PrettyPrint();
		ArrayList<ArrayList<Integer>> solution = prettyPrint.prettyPrint(1);
		for (ArrayList<Integer> arrayList : solution) {
			System.out.println("");
			for (Integer integer : arrayList) {
				System.out.print(integer + " ");
			}

		}

	}

	public ArrayList<ArrayList<Integer>> prettyPrint(int n) {
		ArrayList<ArrayList<Integer>> outer = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < (2 * n - 1); i++) {
			ArrayList<Integer> inner = new ArrayList<Integer>();
			for (int j = 0; j < 2 * n - 1; j++) {
				if (i > ((2 * n - 1) / 2)) {
					inner.add(j, outer.get(2 * n - 2 - i).get(j));
				} else if (j <= i) {
					inner.add(j, n - j);
				} else if (j <= ((2 * n - 1)) / 2) {
					inner.add(j, n - i);
				} else {
					inner.add(j, inner.get(2 * n - 2 - j));
				}
			}
			outer.add(inner);
		}
		return outer;
	}
}
