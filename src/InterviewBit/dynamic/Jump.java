package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.Arrays;

public class Jump {
	public static void main(String[] args) {
		Jump jump = new Jump();
		System.out.println(jump.jump(new ArrayList<Integer>(Arrays.asList(1, 3, 3, 5, 1, 2, 1))));
	}

	public int jump(ArrayList<Integer> a) {
		if (a.size() <= 1) {
			return 0;
		}
		if (a.get(0) == 0) {
			return -1;
		}
		int maxReach = a.get(0);
		int step = a.get(0);
		int jump = 1;
		for (int i = 1; i < a.size(); i++) {
			if (i == a.size() - 1) {
				return jump;
			}

			maxReach = Math.max(maxReach, i + a.get(i));
			step--;
			if (step == 0) {
				if (i >= maxReach) {
					return -1;
				}
				jump++;
				step = maxReach - i;
			}
		}

		return -1;
	}

	public int canJump(ArrayList<Integer> a) {
		int jump = 0;
		int sol = 0;
		for (int i = 0; i < a.size(); i++) {
			if (jump < 0) {
				return 0;
			}
			if (jump < a.get(i)) {
				jump = a.get(i);
				sol++;
			}
			if (i + a.get(i) >= a.size()) {
				return ++sol;
			}

			jump--;
		}

		return sol;

	}

	public int canJump1(ArrayList<Integer> a) {
		int[] dp = new int[a.size()];
		dp[a.size() - 1] = 0;
		for (int i = a.size() - 2; i >= 0; i--) {
			dp[i] = -1;
			if (i + a.get(i) >= a.size() - 1) {
				dp[i] = 1;
				continue;
			}
			for (int j = i + 1; j < dp.length && j <= i + a.get(i); j++) {
				if ((dp[j] > -1) && ((dp[i] == -1) || (dp[i] > dp[j] + 1))) {
					dp[i] = dp[j] + 1;
				}
			}

		}

		return dp[0];
	}
}
