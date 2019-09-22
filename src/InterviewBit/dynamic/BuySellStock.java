package InterviewBit.dynamic;

import java.util.Arrays;
import java.util.List;

public class BuySellStock {
	public static void main(String[] args) {
		BuySellStock buySellStock = new BuySellStock();
		System.out.println(buySellStock.maxProfit(Arrays.asList(1, 2, 1, 2)));
	}

	public int maxProfit(final List<Integer> a) {
		if (a.size() == 0 || a.size() == 1)
			return 0;
		int[] dpl = new int[a.size()];
		int[] dpr = new int[a.size()];

		int min = a.get(0);
		for (int i = 1; i < dpl.length; i++) {
			min = Math.min(min, a.get(i));
			dpl[i] = Math.max(dpl[i - 1], a.get(i) - min);
		}
		int max = a.get(a.size() - 1);
		for (int i = a.size() - 2; i >= 0; i--) {
			max = Math.max(max, a.get(i));
			dpr[i] = Math.max(dpr[i + 1], max - a.get(i));
		}
		int sol = dpl[0] + dpr[0];
		for (int i = 0; i < dpr.length; i++) {
			sol = Math.max(sol, dpl[i] + dpr[i]);

		}

		return sol;
	}
}
