package ds;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		Pair pair1 = new Pair(6, 1);
		Pair pair2 = new Pair(7, 9);
		Pair pair3 = new Pair(2, 2);
		Pair pair4 = new Pair(9, 2);
		Pair pair5 = new Pair(10, 1);
		Pair pair6 = new Pair(1, 3);
		Pair pair7 = new Pair(7, 3);
		Pair pair8 = new Pair(4, 4);
		Pair pair9 = new Pair(0, 5);
		Pair[] arr = new Pair[9];
		arr[0] = pair1;
		arr[1] = pair2;
		arr[2] = pair3;
		arr[3] = pair4;
		arr[4] = pair5;
		arr[5] = pair6;
		arr[6] = pair7;
		arr[7] = pair8;
		arr[8] = pair9;
		java.util.PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.count - b.count);
		pq.add(pair1);
		pq.add(pair2);
		pq.add(pair3);
		pq.add(pair4);
		pq.add(pair5);
		pq.add(pair6);
		pq.add(pair7);
		pq.add(pair8);
		pq.add(pair9);
		while(!pq.isEmpty()){
			System.out.println(pq.remove());
		}
	}
	static class Pair{
		public int val;
		public int count;
		Pair(int val, int count){
			this.val = val;
			this.count = count;

		}

		@Override
		public String toString() {
			return "Pair{" +
					"val=" + val +
					", count=" + count +
					'}';
		}
	}
}
