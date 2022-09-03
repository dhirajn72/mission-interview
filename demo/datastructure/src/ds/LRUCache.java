package ds;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	Node head;
	Node tail;
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

	class Node{
		int key, val ;
		Node next, prev;
		Node(int key, int val){
			this.val =val;
			this.key = key;
		}
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(4);
		System.out.println(cache.get(3));
		cache.put(3,4);
		System.out.println(cache.get(3));
	}
}
