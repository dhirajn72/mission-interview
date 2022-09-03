import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {
	public static void main(String[] args) {
		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> b[1] - a[1]);
		for(int i = 0; i < 10; i++ ){
			q.offer(new int[]{i, i + 2, i - 3});
		}
		while(!q.isEmpty()){
			System.out.println(Arrays.toString(q.poll()));
		}
	}
}
