class Solution {
    public int maximalSquare(char[][] matrix) {

        int n=matrix.length;
        int m=matrix[0].length;
        
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.valueOf(matrix[i][j]+"");
            }
        }

        int res=0;  
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0||j==0){
                    if(dp[i][j]==1){
                        res=Math.max(res,1);
                        continue;
                    }
                }
                if(dp[i][j]==1){
                    if(dp[i][j]!=0 && dp[i-1][j]!=0 && dp[i][j-1]!=0 && dp[i-1][j-1]!=0){
                        dp[i][j] += Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                    }
                        res =Math.max(res, dp[i][j]);
                }

            }
        }
        return res*res;     

    }
}
