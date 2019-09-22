package InterviewBit.graph;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Graph {
	int v;
	ArrayList<ArrayList<Integer>> e;

	public Graph(int v) {
		this.v = v;
		e = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < v; i++) {
			e.add(new ArrayList<Integer>());
		}
	}
}

public class LargestDistance {

	public static void main(String[] args) {
		LargestDistance largestDistance = new LargestDistance();
		System.out.println(largestDistance.solve(new int[] { -1, 0, 0, 1, 2, 1, 5 }));
	}

	public int solve(int[] a) {
		if (a.length == 1) {
			return 0;
		}
		Graph g = new Graph(a.length);
		int root = -1;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1) {
				root = i;
			} else {
				g.e.get(a[i]).add(i);
				g.e.get(i).add(a[i]);
			}

		}
		int[] visited = new int[a.length];
		Deque<Integer> q = new LinkedList<Integer>();
		q.push(root);
		visited[root] = 1;
		int pop = 0;
		while (!q.isEmpty()) {
			pop = q.poll();
			ArrayList<Integer> aList = g.e.get(pop);
			for (int i = 0; i < aList.size(); i++) {
				if (visited[aList.get(i)] == 0) {
					visited[aList.get(i)] = 1;
					q.add(aList.get(i));
				}
			}
		}
		int[] dist = new int[a.length];
		q = new LinkedList<Integer>();
		q.add(pop);
		dist[pop] = 1;
		int sol = -1;
		while (!q.isEmpty()) {
			pop = q.poll();
			ArrayList<Integer> aList = g.e.get(pop);
			for (int i = 0; i < aList.size(); i++) {
				if (dist[aList.get(i)] == 0) {
					dist[aList.get(i)] = dist[pop] + 1;
					sol = Math.max(sol, dist[pop] + 1);
					q.add(aList.get(i));
				}
			}
		}

		return sol - 1;

	}

}
