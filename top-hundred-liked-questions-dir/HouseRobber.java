class Solution {
    public int rob(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        int n=nums.length;
        if(n==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);

        int[] dp=new int[n];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        int max=0;
        for(int i=2;i<n;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
            max=Math.max(max,dp[i]);
        }
        return max;
        
    }
}
