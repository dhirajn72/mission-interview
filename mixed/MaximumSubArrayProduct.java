class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;

        if(nums.length==1)
            return nums[0];
        int n=nums.length;
        int[][] dp=new int[n][n];
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i][i]=nums[i];
            max=Math.max(max,dp[i][i]);
        }

        for(int i=1;i<n;i++){
            int m=nums[i-1]*nums[i];
            dp[i-1][i]=m;
            max=Math.max(max,m);
        }

        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                dp[j][k]= nums[j]*nums[k]*dp[j+1][k-1];
                max=Math.max(max,dp[j][k]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return max;
    }
}
