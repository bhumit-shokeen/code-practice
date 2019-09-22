package graph;

import java.util.LinkedList;

class Graph {
	int v;
	LinkedList<Integer> adjencyList[];

	Graph(int v) {
		this.v = v;
		adjencyList = new LinkedList[v];
		for (int i = 0; i < adjencyList.length; i++) {
			adjencyList[i] = new LinkedList<Integer>();
		}
	}

	void addEdge(int src, int dst) {
		adjencyList[src].add(dst);
		adjencyList[dst].add(src);
	}

	void display() {
		for (int i = 0; i < adjencyList.length; i++) {
			System.out.print(i + " --> ");
			for (Integer integer : adjencyList[i]) {
				System.out.print(" " + integer);
			}
			System.out.println("");
		}
	}
}

public class GraphAsLinledList {
	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		graph.display();
	}
}
