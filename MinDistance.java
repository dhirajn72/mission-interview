class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        int[][] dp=new int[n+1][m+1];
    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = 1 + dp[i][j];
                }
                else{
                    dp[i+1][j+1] = Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        int val=dp[n][m];
        return n - val + m - val; 
    }
}
