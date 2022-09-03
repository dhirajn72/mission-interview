class Solution {
    public int numSubmat(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]==1)
                    count++;
                else
                    count=0;
                
                dp[i][j]=count;
            }
        }
        
        int res=0;
        for(int i = 0;i < n; i++){
            int min=Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                for(int k=i;k<n;k++){
                    min=Math.min(dp[i][j],min);
                    res += min;
                }
            }
        }
        return res;
    }
}
