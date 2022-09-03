class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<n;i++){
            int e=nums[i];
            dp[e]=e;
        }
        
        for(int i=0;i<=n;i++){
            if(dp[i]==Integer.MAX_VALUE)
                return i;
        }
        return -1;
    }
}
