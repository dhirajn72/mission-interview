class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int n=text1.length();
        int m=text2.length();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]= 1 + dp[i-1][j-1]; 
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }

        StringBuilder sb=new StringBuilder();
        for(int i=n,j=m; i>0 && j>0){
             if(dp[i][j]==dp[i-1][j]){
                 i--;
             }
             else if(dp[i][j]==dp[i][j-1]){
                 j--;
             }
             else{
                  sb.append(text1.charAt(i-1));
                  i--;
                  j--;
             }
        }
        return sb.length();
        
    }
}
