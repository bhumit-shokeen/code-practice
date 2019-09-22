package InterviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

class GraphChar {
	private Map<Character, ArrayList<Character>> v;

	public GraphChar() {
		this.v = new HashMap<Character, ArrayList<Character>>();
	}

	public void addVertex(Character vertex) {
		v.put(vertex, new ArrayList<Character>());
	}

	public void addEdge(Character s, Character d) {
		if (!v.get(s).contains(d)) {
			v.get(s).add(d);
		}
	}

	public ArrayList<Character> getAdjList(Character c) {
		return v.get(c);

	}
}

public class DictionaryOrder {
	public static void main(String[] args) {
		DictionaryOrder dictionaryOrder = new DictionaryOrder();
		System.out.println(dictionaryOrder
				.findOrder(new ArrayList<String>(Arrays.asList("bbb", "aaa", "c", "cbd", "eda", "deaprq"))));
	}

	public ArrayList<Character> findOrder(ArrayList<String> s) {
		Set<Character> set = new HashSet<Character>();
		for (String st : s) {
			for (int i = 0; i < st.length(); i++) {
				set.add(st.charAt(i));
			}
		}
		GraphChar graph = new GraphChar();
		for (Character c : set) {
			graph.addVertex(c);
		}

		findEdge(graph, s.get(0));
		for (int i = 1; i < s.size(); i++) {
			findEdge(graph, s.get(i));
			findEdge(graph, s.get(i - 1), s.get(i));

		}

		HashSet<Character> visited = new HashSet<Character>();
		Stack<Character> stack = new Stack<Character>();

		for (Character c : set) {
			if (!visited.contains(c)) {
				topologicalSort(graph, c, visited, stack);
			}
		}
		ArrayList<Character> sol = new ArrayList<Character>();
		while (!stack.isEmpty()) {
			sol.add(stack.pop());
		}
		return sol;

	}

	private void findEdge(GraphChar graph, String s) {
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i - 1) != s.charAt(i)) {
				graph.addEdge(s.charAt(i - 1), s.charAt(i));
			}
		}

	}

	private void findEdge(GraphChar graph, String s, String d) {
		int n = Math.min(s.length(), d.length());
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) != d.charAt(i)) {
				graph.addEdge(s.charAt(i), d.charAt(i));
				return;
			}
		}
	}

	private void topologicalSort(GraphChar graph, Character vertex, HashSet<Character> visited,
			Stack<Character> stack) {
		visited.add(vertex);
		for (Character c : graph.getAdjList(vertex)) {
			if (!visited.contains(c)) {
				topologicalSort(graph, c, visited, stack);
			}
		}
		stack.push(vertex);

	}

}
