import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueue_int_arr {
	public static void main(String[] args) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> (a[1] - b[1]));
		for(int i = 12; i <= 15 ; i++){
			pq.offer(new int[]{i, (i % 2 == 0) ? (i / 2) : (i * 3) + 1});
		}
		Object[] arr = pq.toArray();
		System.out.println(Arrays.toString(arr));
		System.out.println("=============");
		while(!pq.isEmpty()){
			System.out.println(Arrays.toString(pq.poll()));
		}

	}
}
