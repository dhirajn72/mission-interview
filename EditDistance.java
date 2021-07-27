import java.util.*;
class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();

        int[][] dp=new int[n1+1][n2+1];
         for(int i=0;i<n1;i++){
            dp[i][0]=i;
        }
        for(int i=0;i<n2;i++){
            dp[0][i]=i;
        }       
        for(int i=0;i<dp.lenght;i++){
            for(int j=0;j<dp[0].length;j++){
                if(word1.charAt(i)==word2.charAt(j))
                    dp[i+1][j+1]=dp[i][j];
                else
                    dp[i+1][j+1]= 1+Math.min(dp[i][j],Math.min(dp[i][j+1],dp[i+1][j])); 
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return dp[n1][n2];
        
    }
}
