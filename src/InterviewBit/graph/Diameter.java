package InterviewBit.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Graph1 {
	ArrayList<Vertex> vList;
	HashMap<Vertex, ArrayList<Edge>> eList;

	public Graph1() {
		vList = new ArrayList<Vertex>();
		eList = new HashMap<Vertex, ArrayList<Edge>>();
	}

}

class Vertex {
	int v;

	public Vertex(int v) {
		this.v = v;
	}
}

class Edge {
	Vertex destination;
	int weight;

	public Edge(Vertex d, int w) {
		destination = d;
		weight = w;
	}
}

public class Diameter {

	public static void main(String[] args) {
		Diameter diameter = new Diameter();
		System.out.println(diameter.solve(new int[] { -1, 0 }));
	}

	public int solve(int[] a) {

		if (a.length == 1) {
			return 0;
		}
		Graph1 g = new Graph1();
		Vertex current;
		Vertex root = null;
		for (int i = 0; i < a.length; i++) {
			current = new Vertex(i);
			g.vList.add(current);
			if (a[i] != -1) {
				g.eList.put(current, new ArrayList<Edge>(Arrays.asList(new Edge(g.vList.get(a[i]), 0))));
				ArrayList<Edge> temp = g.eList.get(g.vList.get(a[i]));
				if (temp == null) {
					temp = new ArrayList<Edge>(Arrays.asList(new Edge(current, 0)));
				} else {
					temp.add(new Edge(current, 0));
				}

				g.eList.put(g.vList.get(a[i]), temp);
			} else {
				root = current;

			}

		}

		Queue<Vertex> q = new LinkedList<Vertex>();
		Set<Vertex> set = new HashSet<Vertex>();
		q.add(root);
		set.add(root);
		Vertex pop = null;
		while (!q.isEmpty()) {
			pop = q.poll();
			for (Edge e : g.eList.get(pop)) {
				if (!set.contains(e.destination)) {
					q.add(e.destination);
					set.add(e.destination);
				}
			}
		}
		q = new LinkedList<Vertex>();
		HashMap<Vertex, Integer> dist = new HashMap<Vertex, Integer>();
		q.add(pop);
		dist.put(pop, 0);
		int sol = 0;
		while (!q.isEmpty()) {
			pop = q.poll();
			for (Edge e : g.eList.get(pop)) {
				if (dist.get(e.destination) == null) {
					q.add(e.destination);
					dist.put(e.destination, dist.get(pop) + 1);
					sol = Math.max(sol, dist.get(e.destination));

				}
			}
		}

		return sol;
	}

}
