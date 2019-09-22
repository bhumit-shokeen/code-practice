package hacker_earth;
/* IMPORTANT: Multiple classes and nested static classes are supported */

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail

class TestClass {
	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 * 
		 * 
		 * Scanner s = new Scanner(System.in); String name = s.nextLine();
		 * String d[] = name.split(" "); name = s.nextLine(); String a[] =
		 * name.split(" "); int[] in = new int[a.length]; for (int i = 0; i <
		 * a.length; i++) { in[i] = Integer.parseInt(a[i]); }
		 * 
		 * System.out.println(sol2(in, Integer.parseInt(d[1])));
		 */
		System.out.println(sol2(new int[] { 1, 2, 10, 4, 5, 6 }, 2));
		// [10,9,2,5,3,7,101,18]
		// Reading input from STDIN

		// Write your code here

	}

	private static int sol2(int[] a, int d) {
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n];
		dp[0] = 0;
		int len = 0;
		for (int i = 1; i < n; i++) {
			if (a[dp[len]] <= a[i] && dp[len] <= i - d) {
				len++;
				dp[len] = i;
			} else if (a[dp[0]] > a[i] && dp[len] <= i - d) {
				dp[0] = i;
			} else if (a[dp[len]] > a[i] && a[dp[0]] < a[i]) {
				int index = findMid(a, dp, 0, len, a[i]);
				if (index <= i - d) {
					dp[index] = i;
				}
			}
		}
		return len + 1;

	}

	private static int sol(int[] a, int d) {
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n];
		dp[0] = 0;
		int len = 0;
		for (int i = 1; i < n; i++) {
			if (a[dp[len]] <= a[i]) {
				len++;
				dp[len] = i;
			} else if (a[dp[0]] > a[i]) {
				dp[0] = i;
			} else {
				int index = findMid(a, dp, 0, len, a[i]);

				dp[index] = i;

			}
		}
		return len;

	}

	private static int findMid(int[] a, int[] dp, int s, int e, int v) {
		int mid = 0;
		while (e > s) {
			mid = (s + e) / 2;
			if (a[dp[mid]] < v) {
				s = mid + 1;
			} else {
				e = mid;
			}
		}
		return s;
	}

	private static int sol1(int[] a, int d) {
		int n = a.length;
		if (n == 0) {
			return 0;
		}
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (a[j] <= a[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}

		}

		return dp[n - 1];

	}
}
