package InterviewBit.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Stringoholics {

	public static void main(String[] args) {
		Stringoholics s = new Stringoholics();
		System.out.println(s.solve(new ArrayList<String>(Arrays.asList("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
				"babaaaabbaba", "baaaaababaabbaaaaabbbbbbbaabbaaaababbabaababaabaaabbbaaaaa", "abaabb",
				"aababbbbabbaaaabbaaaaaaaababbbabbbbaabbaabaabbaabaababbbababaababaabbababaaabaaaab",
				"babaaaaababbbbbabbbbabbaaabaaaababbabbaabbbabbaaaabbbabaaaabaaaababb",
				"bbbbbbaaaaaabbbbbbababaabaabbbbbaaabbabbaabbbbaaaaaababbabaaabbabbabbbabbaabbabbbbaabbbaaaaabbabaaab",
				"aabaaabaabbbbababbabbabaaaababbababbbabbbbaabbaaaaababbbbbababbbbaaababababab", "aaaababbbaabbbabaabb",
				"ababaaaabbabbbbaaabbababbbabbbabaaa", "aaabaabbbabaa", "baababbababbbbbabbabaabbabbbbbaaaabaaaababaa",
				"babaa",
				"abbabababbbbbbbbbbbaaaaaababbababaaabbbaaaabbbababbabaabbaabbbbaabbbaabbababababaabaaabbaaabbba",
				"ababbaabbaaabbbabaabababbbabaaabbbaababaaa",
				"abbaaaababbbbaaabaaaabaaaaabaababbabbaababbbabbbbbbbbbabbaabaaabbaaababbbaa",
				"bbabababaabbabbabbbabbaababbabaaabbbababab", "abbbaaabaab", "bbaaabbaaabbaabbabababa",
				"aabaabaaaaaaabaabbbaaababbbbbbababbaabababbaaaaabbabbbabbbaababbaabababbbbbbbbbaabaab",
				"babbaaabbabbaabaaabbb", "bbabaabba", "baabaaaaabbaaaaaabbbbaaaabababa", "babbaababaaba",
				"baabaabaabbababbaabbabbbbbabaaaabbbbbabbabbbbbabbbabaabbbbabbbbaaabbbbabababaaaababbaaabbabb",
				"abbbbaaaabaabbabbaababaabbababbbaaabbabbbbbaaabbabbaabbb",
				"bababaaaaabababbabbaabababbbaabbaabaabaabbabbbababbaaabababbababbbb", "abaaabbbabbbaabba",
				"bbbbaaaabbbababaabbbababaaaababbaaaaaabbbabbaababababbba",
				"bababaabaaaabbaabbababbaabbaabaabbaaaaaaaababbaaaaaabbaaabaabaaababbababbbbaabbabbabaabab",
				"aabbbabaaabababaabbbbaabbabaaabbbaaabbabbbbabaabbbbaabbbaaaaabbbabbbbb",
				"aabbbbbbabaabbbabbaababbababaabaaababbbbabbbaababaaaabbaaabaaabaaaabbbabababbab",
				"abaaaaababbabaabbbaaaaabbaaaabaaaaaaaababbaabbbaabbabbbabbaaaaaab",
				"bbbaabbabbbbbbaaaabbabbbbbbbaaabaababbaaaabbbaababbaaabbbbbbbbabbabababbaaabaabaaabaaaabbbbbabaabaaa",
				"bbaaabaaabaaabaabaaabbaabaabbabaabaabbababaaaaabaabbbbaba",
				"abaababaaabbabaabaabbbaaabbaabababbabaaabbbbabbbbbaaaaa", "abba",
				"abbbababbaaabbaaabbbabaabbababaaabbbbaaaaababbabbaabbabbbaaabaabbaaaaabaaaabbbaabbbabbbbbbbabb",
				"bbabbaaabaaaabbaaaabbbaaaababbbaabaaaaab",
				"abbaabaabbaaaaaaaabbaabbabbababaaaaaaabbabaabaabbbabbaabbaababbaabbaba",
				"bbbbaababbaaaaaaaaabbbabbbabaabababaababaababa",
				"baaabaabbbbbbaabbabbbabaaaaababaabaababbbaaaaaaaabbbbbabbabaaaaaaaabababaabaababaaabbaaaaaaaaabaa",
				"aababbbabbaaaaababbabaababbbbbbbbaaabbaaaaabbaabbbba", "ababababaaaaaabbbabbaaababaabb",
				"bababbaababaabbbabbaab", "baababababbaaaaabbbbbbbbbaabababb", "bbbbb",
				"aabaabbbaabababbababaaaaabbbbaababaabbabbbbbbaabbaaabbababbbabbabbbaabbbab",
				"bbaabbbbaabbaaaaaabbbaabababbbaabaaabbbbbabaababbbaababbbaaabaaabaaaababbbbaabbaababb",
				"aaababbaaaaabaabababbabaabbbbabbaba"))));
	}

	public int solve(ArrayList<String> a) {
		int[] t = new int[a.size()];
		for (int i = 0; i < a.size(); i++) {
			int n = 1;
			int l = a.get(i).length();
			while (((n * (n + 1)) / 2) % l != 0) {
				n++;
			}
			t[i] = n;
			System.out.println(i + " : " + t[i] + " : " + l);

		}

		long sol = -1l;
		// find lcm of array t
		long lcm = 1;
		for (int i = 0; i < t.length; i++) {
			if (i == 74)
				System.out.println(i);
			long gcd = gcd(lcm, t[i]);
			lcm = (lcm * t[i]) / gcd;
			// lcm = (((lcm * t[i]) % 1000000007) / gcd) % 1000000007;

			sol = Math.max(sol, lcm);

		}

		return (int) sol % 1000000007;

	}

	private long gcd(long a, long b) {

		if (a < b) {
			return gcd(b, a);
		}

		if (a % b == 0) {
			return b;
		}
		return gcd(b, a % b);

	}

}
