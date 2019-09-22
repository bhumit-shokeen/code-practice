package InterviewBit.array;

import java.util.ArrayList;
import java.util.List;

public class Title {
	public static void main(String[] args) {
		Title title = new Title();
		System.out.println(title.convertToTitle(943566));
	}

	public String convertToTitle(int A) {

		List<Integer> alpha = new ArrayList<Integer>();
		sol(alpha, A);
		String ret = "";
		for (int i = alpha.size() - 1; i >= 0; i--) {
			ret = ret + (char) (int) (alpha.get(i) + 64);
		}
		return ret;
	}

	private void sol(List<Integer> alpha, int a) {
		int r = a % 26;
		int q = a / 26;

		if (r == 0) {
			alpha.add(26);
			q--;
		} else {
			alpha.add(r);
		}

		if (q <= 26 && q != 0) {
			alpha.add(q);
		} else if (q != 0) {
			sol(alpha, q);
		}
	}
}
