class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        numSquares(dp,n);
        return dp[n];
    }
    int numSquares(int[] dp,int n){
        if(dp[n]!=-1)
            return dp[n];
        if(n==0)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int i=1; i*i <=n; i++){
            min=numSquares(n-i*i)+1;
            min=Math.min(min,i);
            dp[i]=min;
        }
        return dp[n];
    }
}
