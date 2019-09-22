package InterviewBit.graph;

//https://www.hackerrank.com/challenges/the-quickest-way-up/problem

import java.util.LinkedList;
import java.util.Queue;

public class LadderSnake {

	public static void main(String[] args) {
		LadderSnake l = new LadderSnake();

		System.out.println(l.quickestWayUp(new int[][] { { 32, 62 }, { 42, 68 }, { 12, 98 } },
				new int[][] { { 95, 13 }, { 97, 25 }, { 93, 37 }, { 79, 27 }, { 75, 19 }, { 49, 47 }, { 67, 17 } }));
	}

	public int quickestWayUp(int[][] ladders, int[][] snakes) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[] visited = new int[101];
		q.add(1);
		visited[1] = 1;
		int pop = -1;
		while (!q.isEmpty()) {
			pop = q.remove();
			// System.out.println("");
			// System.out.print("pop : " + pop);
			for (int i = 1; i <= 6 && (pop + i) <= 100; i++) {
				if (visited[pop + i] == 0) {
					visited[pop + i] = visited[pop] + 1;
					int temp = find(pop + i, ladders);
					if (temp != -1) {
						if (visited[temp] != 0) {
							continue;
						}
						visited[temp] = visited[pop] + 1;
						q.add(temp);
						// System.out.print(" " + temp + " a:" + visited[temp]);
					} else {
						temp = find(pop + i, snakes);
						if (temp != -1) {
							if (visited[temp] != 0) {
								continue;
							}
							visited[temp] = visited[pop] + 1;
							q.add(temp);
							// System.out.print(" " + temp + " a:" +
							// visited[temp]);
						} else {
							q.add(pop + i);
							// System.out.print(" " + (pop + i) + " a:" +
							// visited[pop + i]);
						}

					}

				}
			}
		}

		return visited[100] == 0 ? -1 : visited[100] - 1;

	}

	private int find(int a, int[][] b) {

		for (int i = 0; i < b.length; i++) {
			if (b[i][0] == a) {
				return b[i][1];
			}
		}

		return -1;

	}
}
