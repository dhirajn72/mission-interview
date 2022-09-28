package ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Node head, tail;
	int max ;
	Map<Integer, Node> map = new HashMap<>();
	LRUCache(int size){
		this.head = new Node(0,0);
	 	this.tail = new Node(0,0);
	 	head.next = tail;
	 	tail.prev = head;
	 	this.max = size;
	}
	public void put(int key, int val){
		if(map.containsKey(key)){
			remove(map.get(key));
		}
		if(max == map.size()){
			remove(tail.prev);
		}
		insert(new Node(key, val));
	}
	private void insert(Node node){
		map.put(node.key, node);
		Node headNode = head.next;
		head.next = node;
		node.prev = head;
		node.next = headNode;
		headNode.prev = node;
	}
	private void remove(Node node){
		map.remove(node.val);
		node.prev.next = node.next;
		node.next.prev = node.prev;
	}
	private int get(int key){
		if(map.containsKey(key)){
			Node node = map.get(key);
			remove(node); // remove will remove it from the cache
			insert(node); // insert will insert it at the front of the cache
			return node.val;
		}
		return -1;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node temp = head;
		while(temp != null){
			sb.append(temp.val).append(",");
			temp = temp.next;
		}
		return sb.toString();
	}


	class Node{
		int key, val ;
		Node next, prev;
		Node(int key, int val){
			this.val =val;
			this.key = key;
		}
		@Override
		public String toString(){
			return "Node [ " + this.key + " : " + this.val + "]";
		}

	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(5);
		cache.put(1, 1);
		cache.put(2, 2);
		cache.put(3, 3);
		cache.put(4, 4);
		cache.put(5, 5);
		cache.put(6, 6); // this will be added, and 1 will be removed
		System.out.println(cache.map);
		System.out.println(cache);
		System.out.println(cache.get(3)); // Now, 3 will be put at the very front
		System.out.println(cache);
		System.out.println(cache.get(2)); // Now, 2 will be put at the very front
		System.out.println(cache);
		cache.put(7, 7); // this will remove the oldest element 4
		System.out.println(cache);

	}
}
