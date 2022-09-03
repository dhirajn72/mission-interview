package interval;

public class BurstBalloons {
	static public int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		for(int L = n - 1; L >= 0; L--){
			for(int R = L; R < n; R++){
				for(int i = L; i <= R; i++){
					dp[L][R] = Math.max(dp[L][R],
							(L > 0 ? nums[L - 1] : 1) * nums[i] * (R == n - 1 ? 1 : nums[R + 1])
									+ (L <= i - 1 ? dp[L][i - 1] : 0 ) + (i + 1 <= R ? dp[i + 1][R] : 0)
					);
				}
			}
		}
		return dp[0][n - 1];
	}
	public static void main(String[] args){
		int[]  nums = {3,1,5,8};
		int max = maxCoins(nums);
		System.out.println(max);
	}
}
