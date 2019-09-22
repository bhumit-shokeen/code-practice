package InterviewBit.array.binary_serach;

public class Power {
	public static void main(String[] args) {
		Power power = new Power();
		// System.out.println(power.pow(71045970, 41535484, 64735492));
		System.out.println("--------------");

		System.out.println(power.pow(71045970, 41535484, 64735492));
		System.out.println(power.pow3(71045970, 41535484, 64735492));
	}

	public int pow3(int x, int n, int d) {

		return (int) ((powrec(x, n, d) + d) % d);
	}

	public long powrec(int x, int n, int d) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}

		long res = powrec(x, n / 2, d);
		res = (res * res) % d;
		if (n % 2 == 1) {
			res = (res * x) % d;
		}
		// System.out.println(res);
		return res;
	}

	public int pow(int x, int n, int d) {
		long res = 1;
		long aux = x % d;
		while (n > 0) {
			if (n % 2 == 1)
				res = res * aux % d;
			aux = aux * aux % d;
			n = n / 2;
		}
		if (res < 0)
			res = d + res;
		return (int) res % d;

	}

	public int pow1(int x, int n, int d) {
		if (x == 0) {
			return 0;
		}
		if (n == 0) {
			return 1;
		}
		int sol = x;
		while (n > 1) {
			sol *= sol * sol;
			if (n % 2 != 0) {
				sol *= x;
			}
			n /= 2;

		}
		return sol;
	}

	public int pow2(int x, int n, int d) {
		if (n == 0)
			return 1 % d;
		if (n == 1) {
			if (x < 0) {
				return (x + d) % d;
			}
			return x % d;
		}
		long result = 1;
		long prod = x % d;
		long longd = (long) d;
		while (n != 0) {
			int div = n / 2;
			int mod = n % 2;
			if (mod == 1)
				result = (result * prod) % longd;
			n = div;
			prod = (prod * prod) % longd;
			System.out.println(prod);
		}
		return (int) ((result + d) % d);
	}
}
