package InterviewBit.hash_maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubStringConcat {
	public static void main(String[] args) {
		SubStringConcat concat = new SubStringConcat();

		for (Integer v : concat.findSubstring("bcabbcaabbccacacbabccacaababcbb",
				Arrays.asList("c", "b", "a", "c", "a", "a", "a", "b", "c"))) {
			System.out.println(v);
		}
	}

	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
		int l = b.size();
		int w = l > 0 ? b.get(0).length() : 0;
		if (a.length() < (l * w)) {
			return new ArrayList<Integer>();
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		HashMap<String, Integer> rMap = new HashMap<String, Integer>();
		HashMap<String, Integer> cMap = new HashMap<String, Integer>();
		int requiredHash = 0;
		for (int i = 0; i < b.size(); i++) {
			if (rMap.containsKey(b.get(i))) {
				rMap.put(b.get(i), rMap.get(b.get(i)) + 1);
			} else {
				rMap.put(b.get(i), 1);
			}
		}
		for (int s = 0; s + (w * l) <= a.length(); s++) {
			cMap.clear();
			for (int j = 0; j < l; j++) {
				String temp = a.substring(s + (j * w), s + (j * w) + w);
				if (cMap.containsKey(temp)) {
					cMap.put(temp, cMap.get(temp) + 1);
				} else {
					cMap.put(temp, 1);
				}
				boolean flag = true;
				for (String key : rMap.keySet()) {
					if (!rMap.get(key).equals(cMap.get(key))) {
						flag = false;
						break;
					}
				}
				if (flag) {
					sol.add(s);
				}

			}
		}

		return sol;
	}

	public ArrayList<Integer> findSubstring1(String a, final List<String> b) {
		int[] map = new int[b.size()];
		ArrayList<Integer> sol = new ArrayList<Integer>();
		StringBuffer name = new StringBuffer();

		find(a, b, map, sol, name);

		return sol;
	}

	private void find(String a, List<String> b, int[] map, ArrayList<Integer> sol, StringBuffer name) {
		// base case
		if (name.length() == b.size() * b.get(0).length()) {
			int index = a.indexOf(name.toString());
			while (index != -1) {
				sol.add(index);
				index = a.indexOf(name.toString(), index + 1);
			}
		} else {
			Set<String> check = new HashSet<>();
			for (int i = 0; i < b.size(); i++) {

				if (!check.contains(b.get(i)) && map[i] == 0) {
					check.add(b.get(i));
					map[i] = 1;
					name.append(b.get(i));
					find(a, b, map, sol, name);
					name.delete(name.length() - b.get(0).length(), name.length());
					map[i] = 0;
				}
			}
		}

	}
}
