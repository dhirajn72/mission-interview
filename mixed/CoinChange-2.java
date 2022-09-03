class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int i=1;i<=amount;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<=amount;j++){
                if(i>0){
                    dp[i][j]=dp[i-1][j];
                }
                if(j>=coins[i]){
                    if(dp[i][j]>1+dp[i][j-coins[i]]){
                        dp[i][j]=1+dp[i][j-coins[i]];
                    }
                }
            }
        }
        int res=dp[n-1][amount];
        return res==Integer.MAX_VALUE-1 ? -1 : res;
    }
}
