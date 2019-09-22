package graph;

import java.util.LinkedList;
import java.util.Queue;

public class BreadthFirstSearch {
	int v;
	LinkedList<Integer> adjencyList[];

	public BreadthFirstSearch(int v) {
		this.v = v;
		adjencyList = new LinkedList[v];
		for (int i = 0; i < adjencyList.length; i++) {
			adjencyList[i] = new LinkedList<>();
		}
	}

	void dfs(int v) {
		int visited[] = new int[this.v];
		Queue queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v] = 1;
		util(queue, visited);
	}

	private void util(Queue queue, int[] visited) {
		int pop;
		while (!queue.isEmpty()) {
			pop = (int) queue.poll();
			System.out.println(pop);
			for (int i = 0; i < adjencyList[pop].size(); i++) {
				if (visited[adjencyList[pop].get(i)] == 0) {
					queue.add(adjencyList[pop].get(i));
					visited[adjencyList[pop].get(i)] = 1;
				}
			}
		}

	}

	public static void main(String[] args) {
		BreadthFirstSearch g = new BreadthFirstSearch(5);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		// graph.display();

		g.dfs(2);
	}

	private void addEdge(int i, int j) {
		adjencyList[i].add(j);
		// adjencyList[j].add(i);

	}

}
