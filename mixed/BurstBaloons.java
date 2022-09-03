class Solution {
    public int maxCoins(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        int[][] dp=new int[n][n];
        for(int l=n-1;l>=0;l--){
            for(int r=0;r<n;r++){
                for(int i=l;i<=r;i++){
                    dp[l][r]=Math.max(dp[l][r],nums[i]*(l>0?nums[l-1]:1 )* (r==n-1? 1:nums[r+1])                                         + (l<=i-1 ? dp[l][i-1]:0 )
                                        + (i+1 <= r ? dp[i+1][r]:0));
                }
            }
        }
        return dp[0][n-1];
    }
}
