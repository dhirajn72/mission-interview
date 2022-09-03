package lineardp;

public class GreatestSumDivisibleByThree {

	/**
	 *
	 * This solution is accepted for small inputs but throws TLE for large inputs
	 */
	static int max = Integer.MIN_VALUE;
	static public int maxSumDivThree(int[] nums) {
		if(nums == null)
			return 0;
		backtrack(nums, 0, 0);
		return max;
	}
	static void backtrack(int[] nums, int start, int sum){
		if(sum % 3 == 0){
			max = Math.max(max, sum);
		}
		if(start ==  nums.length)
			return;
		//System.out.println(sum +"::"+start);
		for(int i = start; i < nums.length; i++){
			sum += nums[i];
			backtrack(nums, i + 1, sum);
			sum -= nums[i];
		}
	}


	/**
	 * DP approach
	 *
	 * @param args
	 */
	static public int maxSumDivThree_(int[] nums) {
		int result=0;
		if(nums==null || nums.length==0)
			return 0;

		int[] dp=new int[3];
		dp[1]=Integer.MIN_VALUE;
		dp[2]=Integer.MIN_VALUE;

		for(int x:nums){
			int[] nextDp=new int[3];
			nextDp[0]=Math.max(dp[x%3]+x, dp[0]);
			nextDp[1]=Math.max(dp[(x+1)%3] + x, dp[1]);
			nextDp[2]=Math.max(dp[(x+2)%3] + x, dp[2]);
			dp=nextDp;
		}
		return dp[0];
	}

	public static void main(String[] args) {
		int[] arr = {3,6,5,1,8};
		System.out.println(maxSumDivThree(arr));
		System.out.println(maxSumDivThree_(arr));
	}
}
