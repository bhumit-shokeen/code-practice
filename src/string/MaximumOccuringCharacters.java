package string;

import java.util.Scanner;

public class MaximumOccuringCharacters {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		s.nextLine();
		String main;
		String part;
		MaximumOccuringCharacters obj = new MaximumOccuringCharacters();
		while (t-- > 0) {
			main = s.nextLine();
			part = s.nextLine();
			System.out.println(obj.findSolution(main, part));

		}
	}

	private String findSolution(String main, String part) {
		int start = 0;
		int end = 0;
		int solStart = 0;
		int solEnd = main.length();
		int[] index = new int[26];
		int[] indexRefer = new int[26];
		for (int i = 0; i < part.length(); i++) {
			indexRefer[(part.charAt(i)) - 97] = indexRefer[(part.charAt(i)) - 97] + 1;
		}
		for (int i = 0; i < main.length(); i++) {
			if (part.indexOf(main.charAt(i)) >= 0) {
				end = i;
				index[(main.charAt(i)) - 97] = index[(main.charAt(i)) - 97] + 1;
			}
			while (isComplete(indexRefer, index)) {
				if ((end - start) < (solEnd - solStart)) {
					solEnd = end;
					solStart = start;
				}
				if (part.indexOf(main.charAt(start)) >= 0) {
					index[(main.charAt(start)) - 97] = index[(main.charAt(start)) - 97] - 1;

				}
				start = start + 1;
			}
			// System.out.println(main.substring(start, end + 1));
		}

		return main.substring(solStart, solEnd + 1);
	}

	boolean isComplete(int[] indexRefer, int[] index) {
		for (int i = 0; i < index.length; i++) {
			if (index[i] < indexRefer[i]) {
				return false;
			}

		}
		return true;
	}

}
