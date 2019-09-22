package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class StockOne {
	public static void main(String[] args) {
		StockOne stockOne = new StockOne();
		System.out.println(stockOne.maxProfit(Arrays.asList(2, 1)));
	}

	public int maxProfit(final List<Integer> a) {
		int n = a.size();
		if (n == 0)
			return 0;
		int dpl[] = new int[n];
		int dpr[] = new int[n];
		dpl[0] = a.get(0);
		for (int i = 1; i < n; i++) {
			dpl[i] = Math.min(dpl[i - 1], a.get(i));
		}
		dpr[n - 1] = a.get(n - 1);
		for (int i = n - 2; i >= 0; i--) {
			dpr[i] = Math.max(dpr[i + 1], a.get(i));
		}
		int sol = 0;
		for (int i = 0; i < dpr.length; i++) {
			sol = Math.max(sol, dpr[i] - dpl[i]);
		}
		return sol;
	}
}
