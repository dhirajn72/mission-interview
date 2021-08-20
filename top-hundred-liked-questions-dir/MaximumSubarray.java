class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int[] dp=new int[nums.length];
        int result=Integer.MIN_VALUE;
        dp[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            if(dp[i-1]>0)
                dp[i]=nums[i]+dp[i-1];
            else
                dp[i]=nums[i];
        }
        for(int i:dp)
            result=Math.max(result,i);
        return result;
       
    }
}
