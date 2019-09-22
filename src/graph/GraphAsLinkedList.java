//https://www.geeksforgeeks.org/graph-and-its-representations/
package graph;

import java.util.LinkedList;

public class GraphAsLinkedList {
	int v;
	LinkedList<Integer> adjListArray[];

	public GraphAsLinkedList(int v) {
		this.v = v;
		adjListArray = new LinkedList[v];
		for (int i = 0; i < adjListArray.length; i++) {
			adjListArray[i] = new LinkedList<>();
		}
	}

	public void addEdge(int source, int dest) {
		adjListArray[source].addFirst(dest);
		adjListArray[dest].addFirst(source);
	}

	public void display() {
		for (int i = 0; i < adjListArray.length; i++) {
			System.out.println(adjListArray[i]);
		}
	}

	public void breadthFirstSearch(int vertex) {
		int[] visited = new int[v];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(vertex);
		visited[vertex] = 1;
		int pop;
		while (!queue.isEmpty()) {
			pop = queue.pop();
			System.out.println(pop);
			for (int i : adjListArray[pop]) {
				if (visited[i] == 0) {
					queue.add(i);
					visited[i] = 1;
				}
			}
		}

	}

	public static void main(String[] args) {
		GraphAsLinkedList graph = new GraphAsLinkedList(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// graph.display();

		graph.breadthFirstSearch(0);
	}

}
