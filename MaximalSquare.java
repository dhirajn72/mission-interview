class Solution {
    int result=0;
    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return result;
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=Integer.valueOf(matrix[i][j]+"");
                result=Math.max(dp[i][j],result);
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(dp[i][j]!=0 && dp[i-1][j]!=0 && dp[i][j-1]!=0 && dp[i-1][j-1]!=0)
                    dp[i][j] += Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]));
                result=Math.max(dp[i][j],result);
            }
        }
        System.out.println(Arrays.deepToString(dp));
        return result*result;
    }
}
