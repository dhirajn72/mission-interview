
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins==null || coins.length==0)
            return 0;

        int[] dp=new int[amount+1];
        for(int i=1;i<=amount;i++)
            dp[i]=Integer.MAX_VALUE;

        for(int i=0;i<coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(j>=coins[i]){
                    if(dp[j] > 1+ dp[j-coins[i]])
                        dp[j]= 1 + dp[j-coins[i]];
                }
            }
        }
        
        return dp[amount] ;
    }
}

