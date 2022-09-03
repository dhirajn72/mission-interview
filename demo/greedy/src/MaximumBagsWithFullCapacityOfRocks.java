import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumBagsWithFullCapacityOfRocks {
	public static void main(String[] args) {
		int[] capacity = {91,54,63,99,24,45,78}, rocks = {35,32,45,98,6,1,25};
		int rock = 17;
		maximumBags(capacity, rocks, rock);
	}
	public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
		for (int i = 0; i < capacity.length; i++) {
			pq.offer(new int[]{capacity[i], rocks[i]});
		}
		int result = 0;
		boolean flag = false;
		while (!pq.isEmpty()) {
			int[] iBag = pq.remove();
			System.out.println(Arrays.toString(iBag));
			while (iBag[1] < iBag[0]) {
				iBag[1]++;
				if (additionalRocks-- == 0) {
					flag = true;
					break;
				}
			}
			if (iBag[0] == iBag[1])
				result++;
			if (flag) break;
		}
		System.out.println(result);
		return result;
	}
}
