/**
 *
 * This is dynamic programming approach to solve, it can be solved with divide and conquer approach as well.
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		if(nums==null || nums.length==0)
			return 0;
		if(nums.length==1)
			return nums[0];

		int[] dp=new int[nums.length];
		dp[0]=nums[0];
		for(int i=1;i<nums.length;i++){
			if(dp[i-1]>0){
				dp[i] = dp[i-1]+nums[i];
			}

			else{
				dp[i]=nums[i];
			}
		}
		int max=Integer.MIN_VALUE;
		for(int e:dp){
			max=Math.max(max,e);
		}
		return max;

	}

}
