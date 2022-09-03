package ds;

import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueue_test {
	public static void main(String[] args) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		int[][] arr = {{3, 1},{7, 6},{1, 2},{9, 0},{9, 9},{8, 2}};
		for(int[] ar : arr){
			pq.offer(ar);
		}
		while(!pq.isEmpty()){
			System.out.print(Arrays.toString(pq.poll() ));
		}
	}
}
