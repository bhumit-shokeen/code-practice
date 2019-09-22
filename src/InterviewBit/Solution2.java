package InterviewBit;

public class Solution2 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		int a[] = solution.plusOne(new int[] { 0, 3, 7, 6, 4, 0, 5, 5, 5 });

		for (int i = 0; i < a.length; i++) {
			System.out.println(" " + a[i]);

		}
	}

	public int maxArr(int[] a) {
		int i = 0;
		int j = a.length - 1;
		int sum = Integer.MIN_VALUE;
		int current = 0;
		while (i < j) {
			current = Math.abs(a[i] - a[j]) + Math.abs(i - j);
			if (sum < current) {
				sum = current;
			}

			if ((Math.abs(a[i + 1] - a[j])) > (Math.abs(a[i] - a[j - 1]))) {
				i++;
			} else {
				j--;
			}
		}

		return sum;
	}

	public int maxSubArray(final int[] a) {
		int start = 0;
		int end = 0;
		int sum = Integer.MIN_VALUE;
		int sumWindow = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] + sumWindow >= a[i]) {
				sumWindow = sumWindow + a[i];
				if (a[i] > 0) {
					end = i;
				}
			} else {
				start = i;
				end = i;
				sumWindow = a[i];
			}
			if (sumWindow > sum) {
				sum = sumWindow;
			}
		}
		return sum;
	}

	public int[] plusOne(int[] a) {
		int d;
		int c = 1;
		for (int i = a.length - 1; i >= 0; i--) {
			d = c + a[i];
			c = d / 10;
			d = d % 10;
			a[i] = d;

		}

		int ret[] = new int[a.length + 1];
		if (c == 1) {
			ret[0] = 1;
			for (int i = 0; i < a.length; i++) {
				ret[i + 1] = a[i];
			}
		} else {
			ret = a;
		}
		int counter = 0;
		for (int i = 0; i < ret.length; i++) {
			if (ret[i] == 0) {
				counter++;
				continue;
			}
			break;
		}

		int[] retf = ret;
		if (counter > 0) {
			retf = new int[ret.length - counter];
			for (int i = 0; i < retf.length; i++) {
				retf[i] = ret[i + counter];
			}
		}
		return retf;
	}

}
