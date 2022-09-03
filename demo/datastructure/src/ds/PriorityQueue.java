package ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PriorityQueue {
	public static void main(String[] args) {
		int[] arr={6,7,6,2,3,3,3,3,4,5,6,1,1,1,1,1,0,9,9,8,1,8};
		java.util.PriorityQueue<Integer> minHeap= new java.util.PriorityQueue<>((a,b) -> a - b);
		for(int val:arr)
			minHeap.add(val);

        System.out.println(" Increasing order ");
		while (!minHeap.isEmpty())
			System.out.print(minHeap.remove() + ",");
		System.out.println();
		System.out.println("--------------");
		java.util.PriorityQueue<Integer> maxHeap= new java.util.PriorityQueue<>((a,b) -> b - a);
		for(int val:arr)
			maxHeap.add(val);

        System.out.println(" Decreasing order ");
		while (!maxHeap.isEmpty())
			System.out.print(maxHeap.remove() + ",");
		System.out.println();
		System.out.println("--------------");
		Map<Integer,Integer> map=new HashMap<>();
		for(int val:arr){
			map.put(val,map.getOrDefault(val,0)+1);
		}
		System.out.println("-----------");

        System.out.println(" Sorted increasing order on val");
		java.util.PriorityQueue<Pair> pairPriorityQueue=new java.util.PriorityQueue<>((a,b)->a.val-b.val);
		for(int key:map.keySet()){
			pairPriorityQueue.add(new Pair(key,map.get(key)));
		}
		while (!pairPriorityQueue.isEmpty())
			System.out.print(pairPriorityQueue.remove());
		System.out.println("-----------");

        System.out.println(" Sorted increasing order on key");
		java.util.PriorityQueue<Pair> pairPriorityQueue_1=new java.util.PriorityQueue<>((a,b)->a.key-b.key);
		for(int key:map.keySet()){
			pairPriorityQueue_1.add(new Pair(key,map.get(key)));
		}

		while (!pairPriorityQueue_1.isEmpty())
			System.out.print(pairPriorityQueue_1.remove());
        System.out.println("-----------");
        System.out.println(" Sorted decreasing order on key");
        java.util.PriorityQueue<Pair> pairPriorityQueue_2=new java.util.PriorityQueue<>((a,b) -> b.key-a.key);
		for(int key:map.keySet()){
			pairPriorityQueue_2.add(new Pair(key,map.get(key)));
		}
		while (!pairPriorityQueue_2.isEmpty())
			System.out.print(pairPriorityQueue_2.remove());



	}
	static class Pair {
		int key;
		int val;
		Pair(int key,int val) {
			this.key=key;
			this.val=val;
		}

		@Override
		public String toString() {
			return "[" + key + "," + val +
					']';
		}
	}
}
