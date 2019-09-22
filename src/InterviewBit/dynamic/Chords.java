package InterviewBit.dynamic;

public class Chords {
	public static void main(String[] args) {
		Chords chords = new Chords();
		System.out.println(chords.chordCnt(22));
	}

	public int chordCnt(int a) {
		int[] dp = new int[a + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int i = 2; i < dp.length; i++) {
			dp[i] = 0;
			for (int j = 0; j < i; j++) {
				dp[i] = (int) ((dp[i] + ((1L * dp[i - 1 - j] * dp[j])) % 1000000007) % 1000000007);
			}
		}
		return dp[a];
	}
}
