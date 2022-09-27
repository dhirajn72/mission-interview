import java.util.Arrays;

public class MaxSumAfterPartitioning {
	static public int maxSumAfterPartitioning(int[] A, int K) {
		int N = A.length, dp[] = new int[N + 1];
		for (int i = 1; i <= N; ++i) {
			int curMax = 0, best = 0;
			for (int k = 1; k <= K && i - k >= 0; ++k) {
				curMax = Math.max(curMax, A[i - k]);
				best = Math.max(best, dp[i - k] + curMax * k);
				System.out.println(Arrays.copyOfRange(A, i, k));
			}
			dp[i] = best;
		}
		return dp[N];
	}

	public static void main(String[] args) {
		int[] arr  =  {1,15,7,9,2,5,10};
		int k = 3;
		System.out.println(maxSumAfterPartitioning(arr, k));

	}
}
