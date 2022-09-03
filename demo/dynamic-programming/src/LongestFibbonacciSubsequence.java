import java.util.Arrays;

public class LongestFibbonacciSubsequence {
	static private int lenLongestFibSubseq(int[] nums){
		int[][] dp = new int[nums.length][nums.length];
		int result = 0;
		for(int i = 1; i < nums.length; i++){
			int l = 0, r = i - 1;
			while(l < r){
				int sum = nums[l] + nums[r];
				if(sum > nums[i])
					r--;
				else if(sum < nums[i])
					l++;
				else{
					dp[r][i] = 1 + dp[l][r];
					result = Math.max(result, dp[r][i]);
					l++;
					r--;
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return result == 0 ? result : result + 2;
	}
	public static void main(String[] args){
		int[] nums = {1,2,3,4,5,6,7,8,9};
		System.out.println(lenLongestFibSubseq(nums));
	}
}
