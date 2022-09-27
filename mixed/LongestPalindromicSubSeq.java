class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s==null || s.isEmpty())
            return 0;

        int n=s.length();

        int[][] dp=new int[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=1;
        }
        for(int i=2;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(s.charAt(j)==s.charAt(k))
                    dp[j][k] = 2 + dp[j+1][k-1];
                else
                    dp[j][k] = Math.max(dp[j][k-1],dp[j+1][k]);
            }
        }
        return dp[0][n-1];
    }
}
