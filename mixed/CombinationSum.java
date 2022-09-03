class Solution {
    public int combinationSum4(int[] nums, int target) {
        if(nums==null || nums.length==0 )
            return 0;

        int[] dp=new int[target+1];
        dp[0]=1;
        for(int i=0;i<=target;i++){
            for(int j=0;j<nums.length;j++){
                if(nums[j]+i <= target)
                    dp[i+nums[j]] += dp[i]; 
            }
        }
        return dp[target];
    }
}
