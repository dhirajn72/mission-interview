class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return 0;

        int[][] dp=new int[coins.length][amount+1];
        for(int i=1;i<dp[0].length;i++){
            dp[0][i]=Integer.MAX_VALUE-1;
        }
        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(i>0)
                    dp[i][j]=dp[i-1][j];
                if(j>=coins[i]){
                    if(dp[i][j] > 1+ dp[i][j-coins[i]])
                        dp[i][j]= 1 + dp[i][j-coins[i]];
                }
            }
        }
        return dp[dp.length-1][amount];
    }
}
