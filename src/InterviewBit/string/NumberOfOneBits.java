package InterviewBit.string;

public class NumberOfOneBits {
	public static void main(String[] args) {
		NumberOfOneBits numberOfOneBits = new NumberOfOneBits();
		System.out.println(numberOfOneBits.numSetBits(11L));
	}

	public int numSetBits(long a) {
		int sum = 0;
		while (a > 0) {
			if ((a & 1) == 1) {
				sum++;
			}
			a = a >> 1;
		}

		return sum;
	}
}
