class Solution {
    public int numSubmat(int[][] mat) {
        int R=mat.length;
        int C=mat[0].length;
        int ans=0;

        int[][] dp=new int[mat.length][mat[0].length];
        for(int i=0;i<R;i++){
            int count=0;
            for(int j=0;j<C;j++){
                if(mat[i][j]==1)
                    count++;
                else
                    count=0;
                dp[i][j]=count;
            }
        }
        for(int i=0;i<R;i++){
            for(int j=0;j<C;j++){
                int res=Integer.MAX_VALUE;
                for(int k=i;k<R;k++){
                    res=Math.min(dp[k][j],res);
                    ans+=res;
                }
            }
        }
        return ans;
    }
}
