package InterviewBit.backtrack;

import java.util.ArrayList;
import java.util.HashMap;

public class LetterPhone {
	public static void main(String[] args) {
		LetterPhone letterPhone = new LetterPhone();
		for (String string : letterPhone.letterCombinations("23")) {
			System.out.println(string);
		}

	}

	HashMap<Character, String> map;

	public LetterPhone() {
		map = new HashMap<Character, String>();
		map.put('1', "1");
		map.put('2', "abc");
		map.put('3', "def");
		map.put('4', "ghi");
		map.put('5', "jkl");
		map.put('6', "mno");
		map.put('7', "pqrs");
		map.put('8', "tuv");
		map.put('9', "wxyz");
		map.put('0', "0");

	}

	public ArrayList<String> letterCombinations(String a) {
		ArrayList<String> sol = new ArrayList<String>();
		StringBuffer temp = new StringBuffer();
		findSol(a, 0, temp, sol);
		return sol;
	}

	private void findSol(String a, int i, StringBuffer temp, ArrayList<String> sol) {
		if (i >= a.length()) {
			sol.add(temp.toString());
		} else {
			String current = map.get(a.charAt(i));
			for (int j = 0; j < current.length(); j++) {
				temp.append(current.charAt(j));
				findSol(a, i + 1, temp, sol);
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}
}
