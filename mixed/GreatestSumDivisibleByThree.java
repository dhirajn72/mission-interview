class Solution {
    int result=0;
    public int maxSumDivThree(int[] nums) {

        if(nums==null || nums.length==0)
            return 0;

        int[] dp=new int[3];
        dp[1]=Integer.MIN_VALUE;
        dp[2]=Integer.MIN_VALUE;

        for(int x:nums){
            int[] nextDp=new int[3];
            nextDp[0]=Math.max(dp[x%3]+x,dp[0]);
            nextDp[1]=Math.max(dp[(x+1)%3] + x,dp[1]);
            nextDp[1]=Math.max(dp[(x+2)%3] + x,dp[2]);
            dp=nextDp;
        }
        return dp[0];
    }
}
