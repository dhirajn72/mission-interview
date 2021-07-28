class Solution {
    public boolean stoneGame(int[] piles) {
        if(piles==null||piles.length==0)
            return false;
        Pair[][] dp=new Pair[piles.length][piles.length];
        int m=dp.length;
        int n=dp[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=new Pair();
            }
        }

        for(int i=2;i<=m;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(piles[j]+dp[j+1][k].second>piles[k]+dp[j][k-1].second){
                    dp[j][k].first=piles[j]+dp[j+1][k].second;
                    dp[j][k].second=dp[j+1][k].first;
                }
                else{
                    dp[j][k].first=piles[k]+dp[j][k-1].second;
                    dp[j][k].second=dp[j][k-1].first;
                }
            }
        }
        return dp[0][m-1].first>dp[0][m-1].second;
    }
    
    class Pair{
        int first;
        int second;
    }
}
