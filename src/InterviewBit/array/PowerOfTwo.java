package InterviewBit.array;

import java.util.HashMap;
import java.util.Map;

public class PowerOfTwo {
	public static void main(String[] args) {
		PowerOfTwo powerOfTwo = new PowerOfTwo();
		System.out.println(powerOfTwo.isPower(1024000000));
	}

	public int isPower(int a) {
		if (a == 2) {
			return 0;
		}
		if (a == 1) {
			return 1;
		}
		Map<Integer, Integer> primeNo = new HashMap<Integer, Integer>();
		for (int i = 2; i < Math.sqrt(a) + 1; i++) {
			if (isPrime(primeNo, i)) {
				int power = 1;
				while (a % (Math.pow(i, power)) == 0) {
					power++;
				}
				power--;
				if (power != 0) {
					primeNo.put(i, power);
				}
			}
		}

		if (primeNo.keySet().size() == 1) {
			return 1;
		}
		int minPow = Integer.MIN_VALUE;
		for (Integer key : primeNo.keySet()) {
			if (minPow < primeNo.get(key)) {
				minPow = primeNo.get(key);
			}
		}
		for (Integer key : primeNo.keySet()) {
			int val = primeNo.get(key);
			if (val - minPow == 0) {
				primeNo.put(key, 0);
			}
		}
		for (Integer key : primeNo.keySet()) {
			int val = primeNo.get(key);
			if (val > 0) {
				return 0;
			}
		}
		return 0;
	}

	private boolean isPrime(Map<Integer, Integer> primeNo, int i) {
		for (Integer key : primeNo.keySet()) {
			if (i % key == 0) {
				return false;
			}
		}
		return true;
	}

}
