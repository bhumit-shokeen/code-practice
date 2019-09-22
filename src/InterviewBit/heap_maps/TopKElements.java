package InterviewBit.heap_maps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
	String word;
	int count;

	public Node(String word) {
		this.word = word;
		count = 1;
	}

	@Override
	public int compareTo(Node node) {
		if (this.word.equals(node.word)) {
			return 0;
		}
		if (this.count != node.count) {
			return node.count - this.count;
		}

		return this.word.compareTo(node.word);

	}

}

public class TopKElements {

	public static void main(String[] args) {

		TopKElements o = new TopKElements();
		System.out.println(o.topKFrequent(new String[] { "i", "love", "leetcode", "i", "love", "coding" }, 2));

	}

	public List<String> topKFrequent1(String[] words, int k) {
		Map<String, Node> map = new HashMap<String, Node>();
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		Node temp = null;
		for (int i = 0; i < words.length; i++) {
			if (map.containsKey(words[i])) {
				temp = map.get(words[i]);
				pq.remove(temp);
				temp.count = temp.count + 1;
				pq.add(temp);

			} else {
				temp = new Node(words[i]);
				map.put(words[i], temp);
				pq.add(temp);
			}

		}
		List<String> sol = new ArrayList<String>();
		for (int i = 0; i < k; i++) {
			if (!pq.isEmpty()) {
				sol.add(pq.remove().word);
			}
		}
		return sol;

	}

	public List<String> topKFrequent2(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		List<String> sol = new ArrayList<String>(map.keySet());
		Collections.sort(sol, (a, b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a.compareTo(b));

		return sol.subList(0, k);

	}

	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		PriorityQueue<String> pq = new PriorityQueue<String>(
				(a, b) -> map.get(a) != map.get(b) ? map.get(b) - map.get(a) : a.compareTo(b));

		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);

		}
		for (String word : map.keySet()) {
			pq.add(word);
		}

		List<String> sol = new ArrayList<String>();
		for (int i = 0; i < k; i++) {
			if (!pq.isEmpty()) {
				sol.add(pq.remove());
			}
		}
		return sol;

	}

}
