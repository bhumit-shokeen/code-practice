package InterviewBit;

public class Solution {
	public static void main(String[] args) {
		Solution solution = new Solution();
		int a[] = solution.repeatedNumber(new int[] { 3, 1, 2, 5, 3 });

		for (int i = 0; i < a.length; i++) {
			System.out.println(" " + a[i]);
		}
	}

	public int[] repeatedNumber(final int[] A) {
		long sum = 0;
		long sum2 = 0;
		long sumAb = 0;
		long sum2Ab = 0;
		int n = A.length;
		for (int i = 0; i < A.length; i++) {
			sumAb = sumAb + A[i];
			sum2Ab = sum2Ab + (A[i] * A[i]);
		}
		sum = (n * (n + 1)) / 2L;
		sum2 = (n * (n + 1) * (2 * n + 1)) / 6L;
		long a2minusB2 = sum2Ab - sum2;
		long aMinusB = sumAb - sum;
		long aPlusB = a2minusB2 / aMinusB;

		int a = (int) ((aPlusB + aMinusB) / 2);
		int b = (int) (a - aMinusB);
		return new int[] { a, b };
	}
}
