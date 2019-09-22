package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class LongestAP {
	public static void main(String[] args) {
		LongestAP longestAP = new LongestAP();
		System.out.println(longestAP.solve(Arrays.asList(100)));
	}

	public int solve(final List<Integer> a) {
		int sol = 1;
		int temp = 1;
		int last, cd;
		for (int i = 0; i < a.size(); i++) {
			for (int j = i + 1; j < a.size(); j++) {
				temp = 2;
				cd = a.get(j) - a.get(i);
				last = a.get(j);
				for (int k = j + 1; k < a.size(); k++) {
					if (a.get(k) == last + cd) {
						temp++;
						last = a.get(k);
					}
				}
				if (sol < temp) {
					sol = temp;
				}
			}
		}

		return sol;
	}
}
