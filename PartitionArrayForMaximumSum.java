class Solution {
    public int maxSumAfterPartitioning(int[] A, int K) {
        int N = A.length;
        int dp[] = new int[N];
        for (int i = 0; i < N; ++i) {
            int curMax = 0;

            // Find out Why i-k+1 ?
            for (int k = 1; k <= K && i - k + 1 >= 0; ++k) {
                curMax = Math.max(curMax, A[i - k + 1]);
                if(i>=k){
                    dp[i]=Math.max(dp[i],dp[i-k] + curMax * k);
                }
                else{
                    dp[i]=Math.max(dp[i], curMax * k);
                }
            }
        }
        return dp[N - 1];
    }
}
