//https://www.geeksforgeeks.org/solve-dynamic-programming-problem/
package dynamic;

public class SumCombinationBasic {
	public static void main(String[] args) {
		SumCombinationBasic basic = new SumCombinationBasic();
		System.out.println(basic.findCombination(new int[] { 1, 3, 5 }, 6));
		System.out.println(basic.findCombinationDynamicProgramming(new int[] { 1, 3, 5 }, 6,
				new int[] { -1, -1, -1, -1, -1, -1, -1 }));
	}

	private int findCombination(int[] input, int sum) {
		if (sum == 0)
			return 1;

		int thisSum = 0;
		for (int i = 0; i < input.length; i++) {
			if (sum - input[i] >= 0) {
				thisSum = thisSum + findCombination(input, sum - input[i]);
			}
		}

		return thisSum;

	}

	private int findCombinationDynamicProgramming(int[] input, int sum, int[] save) {

		if (save[sum] < 0) {
			if (sum == 0)
				return 1;

			int thisSum = 0;
			for (int i = 0; i < input.length; i++) {
				if (sum - input[i] >= 0) {
					thisSum = thisSum + findCombinationDynamicProgramming(input, sum - input[i], save);
				}
			}
			save[sum] = thisSum;
			return thisSum;

		} else
			return save[sum];
	}

}
