public class HashMap {
	static final ListNode[] nodes = new ListNode[10000];

	static public void put(int key, int value) {
		int i = idx(key);
		if (nodes[i] == null)
			nodes[i] = new ListNode(-1, -1);
		ListNode prev = find(nodes[i], key);
		if (prev.next == null)
			prev.next = new ListNode(key, value);
		else
			prev.next.val = value;
	}

	static public int get(int key) {
		int i = idx(key);
		if (nodes[i] == null)
			return -1;
		ListNode node = find(nodes[i], key);
		return node.next == null ? -1 : node.next.val;
	}

	static public void remove(int key) {
		int i = idx(key);
		if (nodes[i] == null) return;
		ListNode prev = find(nodes[i], key);
		if (prev.next == null) return;
		prev.next = prev.next.next;
	}

	static int idx(int key) { return key % nodes.length;}

	static ListNode find(ListNode bucket, int key) {
		ListNode node = bucket, prev = null;
		while (node != null && node.key != key) {
			prev = node;
			node = node.next;
		}
		return prev;
	}

	static class ListNode {
		int key, val;
		ListNode next;

		ListNode(int key, int val) {
			this.key = key;
			this.val = val;
		}
	}

	public static void main(String[] args) {
		put(35, 32);
		//put(21, 90);
		//put(89, 81);
		put(35, 31);
		System.out.println(get(23));
		System.out.println(get(35));
	}
}
