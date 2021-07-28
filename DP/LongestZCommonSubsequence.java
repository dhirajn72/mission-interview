class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m=text1.length();
        int n=text2.length();
        
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=m,j=n;i>0 && j>0;){
            if(dp[i][j]==dp[i-1][j])
                i--;
            else if(dp[i][j]==dp[i][j-1])
                j--;
            else{
                sb.append(text1.charAt(i));
                i--;
                j--;
            }
        }
        return sb.length();
    }
}
