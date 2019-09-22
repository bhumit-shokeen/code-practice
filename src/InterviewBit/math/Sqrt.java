package InterviewBit.math;

public class Sqrt {

	public static void main(String[] args) throws java.lang.Exception {
		System.out.println(new Sqrt().mySqrt(8));
	}

	public int mySqrt(int x) {
		long s = 1;
		long e = x;
		long mid = 0;
		while (e >= s) {
			mid = (s + e) / 2;
			// System.out.println(mid);

			if (mid * mid <= x && (mid + 1) * (mid + 1) > x) {
				return (int) mid;
			} else if (mid * mid > x) {
				e = mid;
			} else {
				s = mid;
			}
		}

		return 0;

	}

}
