package InterviewBit.heap_maps;

import java.util.ArrayList;
import java.util.HashMap;

public class Cache {
	public static void main(String[] args) {

		Cache cache = new Cache(7);
		cache.set(2, 1);
		cache.set(1, 10);
		cache.set(8, 13);
		System.out.println(cache.get(12));
		cache.set(2, 8);
		System.out.println(cache.get(11));
		System.out.println(cache.get(7));
		cache.set(14, 7);
		cache.set(12, 9);
		cache.set(7, 10);
		System.out.println(cache.get(11));
		cache.set(9, 3);
		cache.set(14, 15);
		System.out.println(cache.get(15));
		System.out.println(cache.get(9));
		cache.set(4, 13);
		System.out.println(cache.get(3));
		cache.set(13, 7);

		System.out.println(cache.get(2));

		cache.set(5, 9);
		System.out.println(cache.get(6));
	}

	HashMap<Integer, Integer> cache;
	ArrayList<Integer> accessOrder;
	int capacity;

	public Cache(int capacity) {
		cache = new HashMap<Integer, Integer>(capacity);
		accessOrder = new ArrayList<Integer>(capacity);
		this.capacity = capacity;
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

	public void set(int key, int value) {
		if (cache.size() < capacity) {
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

		} else if (!cache.containsKey(key)) {
			int pop = accessOrder.get(0);
			accessOrder.remove(0);
			cache.remove(pop);
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
