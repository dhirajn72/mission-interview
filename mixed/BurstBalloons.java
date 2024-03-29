class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int L = n - 1; L >= 0; L--){
            for(int R = L; R < n; R++){
                for(int i = L; i <= R; i++){
                    dp[L][R] = Math.max(dp[L][R], nums[i] * (L > 0 ? nums[L - 1] : 1) * (R == n - 1 ? 1 : nums[R + 1]) 
                                    + (L <= i - 1 ? dp[L][i - 1] : 0) + (i + 1 <= R ? dp[i + 1][R] : 0));
                }
            }
        }
        return dp[0][n - 1];
    }
}
