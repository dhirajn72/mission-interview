import java.util.Arrays;

public class MaxNumberDivisibleByThree {
	static int res = 0;
	static public int maxSumDivThree(int[] nums) {
		int[] dp = new int[3];
		Arrays.fill(dp, Integer.MIN_VALUE);
		dp[0] = 0;
		for(int e : nums) {
			int[] nextDp = new int[3];
			nextDp[0] = Math.max(dp[e % 3] + e, dp[0]);
			nextDp[1] = Math.max(dp[(e + 1) % 3] + e, dp[1]);
			nextDp[2] = Math.max(dp[(e + 2) % 3] + e, dp[2]);
			dp = nextDp;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		int[] arr = {3,6,5,1,8};
		System.out.println(maxSumDivThree(arr));
	}
}
