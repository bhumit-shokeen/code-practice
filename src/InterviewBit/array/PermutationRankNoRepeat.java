package InterviewBit.array;

import java.util.ArrayList;
import java.util.List;

public class PermutationRankNoRepeat {
	public static void main(String[] args) {
		PermutationRankNoRepeat permutationRank = new PermutationRankNoRepeat();
		System.out.println(permutationRank.findRank("AaBb"));

	}

	public int findRank(String A) {
		List<Long> factorial = new ArrayList<Long>();
		factorial.add(1L);
		factorial.add(1L);
		// System.out.println(fact(50));
		int[] hash = new int[52];
		for (int i = 0; i < A.length(); i++) {
			// System.out.println(i + " " + A.charAt(i));
			if ('A' <= A.charAt(i) && A.charAt(i) <= 'Z') {
				hash[(A.charAt(i) - 'A')]++;

			} else
				hash[(A.charAt(i) - 'a') + 26]++;
		}
		long sol = 0;
		for (int i = 0; i < A.length(); i++) {

			if ('A' <= A.charAt(i) && A.charAt(i) <= 'Z') {
				for (int j = 0; j < (A.charAt(i) - 'A'); j++) {
					if (hash[j] > 0) {
						hash[j]--;
						sol += count(hash, factorial);
						hash[j]++;
					}
				}
				hash[(A.charAt(i) - 'A')]--;
			} else {
				for (int j = 0; j < (A.charAt(i) - 'a') + 26; j++) {
					if (hash[j] > 0) {
						hash[j]--;
						sol += count(hash, factorial);
						hash[j]++;
					}
				}
				hash[(A.charAt(i) - 'a') + 26]--;

			}
		}

		sol++;
		return (int) (sol % 1000003);
	}

	long count(int[] hash, List<Long> factorial) {
		int total = 0;
		// List<Integer> divisor = new ArrayList<Integer>();
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > 0) {
				total += hash[i];
			}

		}
		long solution = fact(total, factorial);

		return solution;

	}

	long fact(int x, List<Long> factorial) {
		if (x < factorial.size()) {
			return factorial.get(x);
		}
		long sol = 1L;
		for (int i = factorial.size() - 1; i < x; i++) {
			sol = (factorial.get(i) * (i + 1)) % 1000003;
			factorial.add(sol);
		}
		return sol;
	}

}
