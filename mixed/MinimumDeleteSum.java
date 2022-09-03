public class MinimumDeleteSum {
    public int minimumDeleteSum(String s1, String s2) {
 
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <=n; i++) {
            dp[i][0]=s1.charAt(i-1);
        }
        for(int i=1;i<=m;i++){
            dp[0][1]=s2.charAt(i-1);
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                dp[i][j]=dp[i-1][j-1]+ ( (s1.charAt(i-1)==s2.charAt(j-1)?0: (s1.charAt(i-1)+s2.charAt(j-1))));
                dp[i][j]=Math.min(dp[i][j], Math.min(dp[i-1][j]+s1.charAt(i-1), dp[i][j-1]+s2.charAt(j-1)));
            }
        }
        return dp[n][m];
  }
}
