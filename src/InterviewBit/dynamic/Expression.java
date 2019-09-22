package InterviewBit.dynamic;

public class Expression {
	public static void main(String[] args) {
		Expression expression = new Expression();
		System.out.println(expression.cnttrue("T|T&F^T"));
	}

	public int cnttrue(String a) {
		int n = a.length();
		int dpt[][] = new int[n][n];
		int dpf[][] = new int[n][n];

		for (int i = 0; i < dpf.length; i = i + 2) {
			dpt[i][i] = a.charAt(i) == 'T' ? 1 : 0;
			dpf[i][i] = a.charAt(i) == 'F' ? 1 : 0;
		}
		int solT = 0;
		int solF = 0;
		for (int i = 2; i < dpf.length; i = i + 2) {
			for (int j = 0; j < dpf.length && j + i < n; j = j + 2) {
				// i = j j= j+i
				int s = j;
				int e = j + i;
				solT = 0;
				solF = 0;
				for (int k = s + 1; k < e; k = k + 1) {
					if (a.charAt(k) == '|') {
						solT = (solT + dpt[s][k - 1] * dpt[k + 1][e]) % 1003;
						solT = (solT + dpt[s][k - 1] * dpf[k + 1][e]) % 1003;
						solT = (solT + dpf[s][k - 1] * dpt[k + 1][e]) % 1003;

						solF = (solF + dpf[s][k - 1] * dpf[k + 1][e]) % 1003;

					} else if (a.charAt(k) == '&') {
						solT = (solT + dpt[s][k - 1] * dpt[k + 1][e]) % 1003;

						solF = (solF + dpf[s][k - 1] * dpf[k + 1][e]) % 1003;
						solF = (solF + dpt[s][k - 1] * dpf[k + 1][e]) % 1003;
						solF = (solF + dpf[s][k - 1] * dpt[k + 1][e]) % 1003;

					} else {
						solT = (solT + dpt[s][k - 1] * dpf[k + 1][e]) % 1003;
						solT = (solT + dpf[s][k - 1] * dpt[k + 1][e]) % 1003;

						solF = (solF + dpt[s][k - 1] * dpt[k + 1][e]) % 1003;
						solF = (solF + dpf[s][k - 1] * dpf[k + 1][e]) % 1003;
					}

				}
				dpt[s][e] = solT;
				dpf[s][e] = solF;

			}
		}

		return dpt[0][n - 1];
	}
}
