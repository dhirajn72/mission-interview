class Solution {
    public int numTrees(int n) {
        if(n==0)
            return 0;

        int[] dp=new int[n];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                int k=i-j-1;
                dp[i] +=  dp[j]*dp[k];
            }
        }
        return dp[n-1];
    }
}

/**



1  1
2  2
3  5
4  14
5  42
6  132
7  429
8  1430
9  4862
**/
