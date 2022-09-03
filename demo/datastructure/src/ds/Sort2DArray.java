package ds;

import java.util.Arrays;

public class Sort2DArray {
	public static void main(String[] args) {
		int[][] nums={{10,16},{2,8},{1,6},{7,12}};
		Arrays.sort(nums, (a, b) -> a[0] - b[0]);
		System.out.println(Arrays.deepToString(nums));
	}
}
