package InterviewBit.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Ranking {
	int rank;
	int index;

	Ranking(int rank, int index) {
		this.rank = rank;
		this.index = index;
	}

	int getRank() {
		return this.rank;
	}

	int getIndex() {
		return this.index;
	}
}

public class HotelReviews {
	public static void main(String[] args) {
		HotelReviews hotelReviews = new HotelReviews();
		for (Integer i : hotelReviews.solve("cool_ice_wifi",
				new ArrayList<String>(Arrays.asList("water_is_cool", "cold_ice_drink", "cool_wifi_speed")))) {
			System.out.println(i);
		}
	}

	public ArrayList<Integer> solve(String a, ArrayList<String> b) {
		Set<String> set = new HashSet<String>();
		PriorityQueue<Ranking> pq = new PriorityQueue<Ranking>(
				Comparator.comparing(Ranking::getRank).reversed().thenComparing(Ranking::getIndex));
		set.addAll(Arrays.asList(a.split("_")));

		for (int i = 0; i < b.size(); i++) {
			pq.add(getRanking(b.get(i), set, i));
		}
		ArrayList<Integer> sol = new ArrayList<Integer>();
		while (!pq.isEmpty()) {
			sol.add(pq.poll().index);
		}
		return sol;
	}

	private Ranking getRanking(String b, Set<String> set, int index) {
		int rank = 0;
		for (String string : b.split("_")) {
			if (set.contains(string)) {
				rank++;
			}
		}

		return new Ranking(rank, index);
	}
}
