package InterviewBit.array;

import java.util.HashMap;
import java.util.Map;

public class PowerTestTwo {
	public static void main(String[] args) {
		PowerTestTwo powerOfTwo = new PowerTestTwo();
		System.out.println(powerOfTwo.isPower(108));
	}

	public int isPower(int a) {
		if (a == 2) {
			return 0;
		}
		if (a == 1) {
			return 1;
		}
		Map<Integer, Integer> primeNo = new HashMap<Integer, Integer>();
		for (int i = 2; i <= a; i++) {
			if (isPrime(primeNo, i)) {
				int power = 1;
				while (a % (Math.pow(i, power)) == 0) {
					power++;
				}
				power--;
				if (power != 0) {
					a = (int) (a / (Math.pow(i, power)));
					primeNo.put(i, power);
				}
			}
		}
		if (primeNo.size() == 0) {
			return 0;
		}
		for (Integer key : primeNo.keySet()) {
			if (primeNo.get(key) == 1) {
				return 0;
			}
		}

		return 1;
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
