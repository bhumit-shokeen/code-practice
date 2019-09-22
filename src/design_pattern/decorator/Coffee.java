package design_pattern.decorator;

public class Coffee {
	public static void main(String[] args) {
		Beverage beverage = new Expresso();
		System.out.println(beverage.getDescription() + " cost" + beverage.cost());

		beverage = new Mocha(beverage);
		System.out.println(beverage.getDescription() + " cost" + beverage.cost());

		// int[] aa = new Coffee().flip("0011101");
		// int[] a = new Coffee().flip("111");
		int[] a = new Coffee().flip("0111000100010");
		for (int i = 0; i < a.length; i++) {
			System.out.println("i: " + a[i]);
		}
	}

	public int[] flip(String A) {
		if (A.length() == 0)
			return new int[] {};

		int[] dp = new int[A.length()];
		dp[0] = A.charAt(0) == '0' ? 1 : -1;

		for (int i = 1; i < A.length(); i++) {
			if (A.charAt(i) == '0') {
				if (dp[i - 1] > 0) {
					dp[i] = dp[i - 1] + 1;
				} else {
					dp[i] = 1;
				}
			} else {
				dp[i] = dp[i - 1] - 1;
			}

		}
		boolean hooked = false;
		int firstPositiveIndex = -1;
		int MaxValue = dp[0];
		int MaxIndex = 0;
		for (int i = 0; i < dp.length; i++) {
			if (dp[i] > MaxValue) {
				MaxValue = dp[i];
				MaxIndex = i;
			}
		}
		for (int i = MaxIndex; i >= 0; i--) {
			if (dp[i] == 1) {
				firstPositiveIndex = i;
			}
			if (i != 0 && dp[i - 1] < dp[i] - 1) {
				break;
			}

		}
		if (firstPositiveIndex == -1) {
			return new int[] {};
		}
		return new int[] { firstPositiveIndex + 1, MaxIndex + 1 };
	}
}
