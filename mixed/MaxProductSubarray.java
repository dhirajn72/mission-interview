class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=1;
        for(int i=0;i<n;i++){
            dp[i+1]=Math.max(dp[i]*nums[i],nums[i]);
        }
        int result=Integer.MIN_VALUE;
        for(int i=1;i<dp.length;i++){
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
