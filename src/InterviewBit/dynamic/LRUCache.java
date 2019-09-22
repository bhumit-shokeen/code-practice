package InterviewBit.dynamic;

import java.util.ArrayList;
import java.util.HashMap;

public class LRUCache {
	public static void main(String[] args) {

		/*
		 * add 5 3 add 1 2 get 5 evict get 1 remove 5
		 */
		Cache cache = new Cache();
		System.out.println(cache.get(5));
		System.out.println(cache.remove(1));
		cache.evict();
		cache.add(5, 3);
		cache.add(1, 2);
		System.out.println(cache.get(5));
		cache.add(1, 9);
		cache.evict();
		System.out.println(cache.get(5));
		System.out.println(cache.remove(1));
	}

}

class Cache {

	HashMap<Integer, Integer> cache;
	ArrayList<Integer> accessOrder;

	public Cache() {
		cache = new HashMap<Integer, Integer>();
		accessOrder = new ArrayList<Integer>();

	}

	public int get(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		int pop = accessOrder.indexOf(key);
		accessOrder.remove(pop);
		accessOrder.add(key);
		return cache.get(key);

	}

	public int remove(int key) {
		if (!cache.containsKey(key)) {
			return -1;
		}
		int pop = accessOrder.indexOf(key);
		accessOrder.remove(pop);
		int sol = cache.get(key);
		cache.remove(key);

		return sol;
	}

	public void evict() {
		if (cache.size() != 0) {
			int key = accessOrder.get(0);
			accessOrder.remove(0);
			cache.remove(key);
		}

	}

	public void add(int key, int value) {
		if (!cache.containsKey(key)) {
			cache.put(key, value);
			accessOrder.add(key);
		} else {
			int pop = accessOrder.indexOf(key);
			accessOrder.remove(pop);
			accessOrder.add(key);
			cache.remove(key);
			cache.put(key, value);

		}

	}
}