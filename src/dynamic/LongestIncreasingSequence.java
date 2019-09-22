//https://www.geeksforgeeks.org/longest-increasing-subsequence/
package dynamic;

public class LongestIncreasingSequence {
	public static void main(String[] args) {
		LongestIncreasingSequence increasingSequence = new LongestIncreasingSequence();
		System.out.println(increasingSequence.findLis(new int[] { 3, 10, 2, 1, 20 }));
		System.out.println(increasingSequence.findLis(new int[] { 3, 2 }));
		System.out.println(increasingSequence.findLis(new int[] { 50, 3, 10, 7, 40, 80 }));
	}

	private int findLis(int[] input) {
		int[] lis = new int[input.length];
		for (int i = 0; i < lis.length; i++) {
			lis[i] = 1;
		}
		int lastMax = 0;
		int ans = 0;
		for (int i = 1; i < input.length; i++) {
			for (int j = 0; j < i; j++) {
				if (input[j] < input[i]) {
					if (lastMax < lis[j]) {
						lastMax = lis[j];

					}
				}
			}
			lis[i] = lastMax + 1;
			if (ans < lis[i]) {
				ans = lis[i];
			}
		}
		return ans;
	}

}
