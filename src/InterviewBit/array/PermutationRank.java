package InterviewBit.array;

import java.util.ArrayList;
import java.util.List;

public class PermutationRank {
	public static void main(String[] args) {
		PermutationRank permutationRank = new PermutationRank();
		System.out.println(permutationRank.findRank("asasdsdsadasdadsadasdsa"));

	}

	public int findRank(String A) {
		List<Long> factorial = new ArrayList<Long>();
		factorial.add(1L);
		factorial.add(1L);
		// System.out.println(fact(50));
		int[] hash = new int[52];
		for (int i = 0; i < A.length(); i++) {
			// System.out.println(i + " " + A.charAt(i));
			if ('a' <= A.charAt(i) && A.charAt(i) <= 'z') {
				hash[2 * (A.charAt(i) - 'a') + 1]++;

			} else
				hash[2 * (A.charAt(i) - 'A')]++;
		}
		long sol = 0;
		for (int i = 0; i < A.length(); i++) {

			if ('a' <= A.charAt(i) && A.charAt(i) <= 'z') {
				for (int j = 0; j < 2 * (A.charAt(i) - 'a') + 1; j++) {
					if (hash[j] > 0) {
						hash[j]--;
						sol += count(hash, factorial);
						hash[j]++;
					}
				}
				hash[2 * (A.charAt(i) - 'a') + 1]--;
			} else {
				for (int j = 0; j < 2 * (A.charAt(i) - 'A'); j++) {
					if (hash[j] > 0) {
						hash[j]--;
						sol += count(hash, factorial);
						hash[j]++;
					}
				}
				hash[2 * (A.charAt(i) - 'A')]--;

			}
		}

		System.out.println("check " + modExp(2, 5));
		sol++;
		return (int) (sol % 1000003);
	}

	long count(int[] hash, List<Long> factorial) {
		int total = 0;
		List<Integer> divisor = new ArrayList<Integer>();
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > 0) {
				total += hash[i];
			}
			if (hash[i] > 1) {
				divisor.add(hash[i]);
			}
		}
		long solution = fact(total, factorial);
		for (int i = 0; i < divisor.size(); i++) {
			solution = solution / fact(divisor.get(i), factorial);
		}
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

	public long modExp(long xint, long yint) {
		long res = 1;
		long x = xint;
		long y = yint;
		// System.out.println("Exp " + x + " " + y + " " + res);
		while (y > 0) {
			if ((y & 1) == 1) {
				res = (res * x) % 1000003;
			}
			x = (x * x) % 1000003;
			y >>= 1;
			// System.out.println("Exp " + x + " " + y + " " + res);
		}
		// return new Long(res).intValue();
		return res;
	}
}
