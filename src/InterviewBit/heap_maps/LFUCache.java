package InterviewBit.heap_maps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class NodeCount {
	Integer key;
	Integer value;
	Integer count;
	Long time;

	public NodeCount(int key, int value, Long time) {
		this.key = key;
		this.value = value;
		count = 1;
		this.time = time;
	}

}

class LFUCache {
	Map<Integer, NodeCount> map;
	Queue<NodeCount> pq;
	Integer capacity;
	Long time;

	public LFUCache(int capacity) {
		map = new HashMap<Integer, NodeCount>();
		pq = new PriorityQueue<NodeCount>((a, b) -> a.count != b.count ? a.count - b.count : (int) (a.time - b.time));
		this.capacity = capacity;
		time = 0L;
	}

	public int get(int key) {
		if (capacity > 0 & map.containsKey(key)) {
			NodeCount temp = map.get(key);
			pq.remove(temp);
			temp.count = temp.count + 1;
			temp.time = ++time;
			pq.add(temp);

			return temp.value;
		}

		return -1;

	}

	public void put(int key, int value) {
		if (capacity < 1)
			return;
		NodeCount temp = null;
		if (map.containsKey(key)) {
			temp = map.get(key);
			pq.remove(temp);
			temp.value = value;
			temp.count = temp.count + 1;
			temp.time = ++time;
			pq.add(temp);
			return;

		}

		temp = new NodeCount(key, value, ++time);
		map.put(key, temp);
		if (map.size() > capacity) {
			map.remove(pq.remove().key);
		}
		pq.add(temp);

	}
}