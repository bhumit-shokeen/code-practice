package InterviewBit.heap_maps;

import java.util.HashMap;
import java.util.Map;

class NodeLink {
	int k;
	int v;
	NodeLink next;
	NodeLink pre;

	public NodeLink(int k, int v) {
		this.k = k;
		this.v = v;
		next = null;
		pre = null;

	}
}

class LRUCache {

	Map<Integer, NodeLink> map;
	NodeLink head;
	NodeLink tail;
	int capacity;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap<Integer, NodeLink>();
		head = new NodeLink(0, 0);
		tail = new NodeLink(0, 0);
		head.next = tail;
		tail.pre = head;
	}

	public int get(int key) {
		if (!map.containsKey(key)) {
			return -1;
		}
		NodeLink temp = map.get(key);
		// System.out.println(temp.v);
		remove(temp);
		add(temp);

		return temp.v;

	}

	public void put(int key, int value) {
		NodeLink temp;
		if (!map.containsKey(key)) {

			temp = new NodeLink(key, value);
			// map.put(key,temp);
			if (map.size() == capacity) {

				remove(tail.pre);
			}
			add(temp);
		} else {
			temp = map.get(key);
			temp.v = value;
			remove(temp);
			add(temp);

		}

	}

	private void remove(NodeLink temp) {
		map.remove(temp.k);
		temp.next.pre = temp.pre;

		temp.pre.next = temp.next;

	}

	private void add(NodeLink temp) {
		map.put(temp.k, temp);
		temp.next = head.next;
		head.next.pre = temp;
		head.next = temp;
		temp.pre = head;
	}
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */