import java.util.*;
class Solution {
    public boolean stoneGame(int[] piles) {
       int n=piles.length;
       int[][] dp=new int[n][n];
       for(int i=0;i<n;i++)
           dp[i][i]=piles[i];

        for(int i=1;i<n;i++){
            for(int j=0;j<n-i;j++){
                int k=i+j;
                dp[j][k]= Math.max(piles[j]-dp[j+1][k],piles[k]-dp[j][k-1]);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[0][n-1]>=0;
    }
}
