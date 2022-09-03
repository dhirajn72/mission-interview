public class UniquePaths {
	static	public int uniquePaths(int m, int n) {
			int[][] dp = new int[m][n];
			dfs(dp, m - 1, n - 1);
			return dp[m - 1][n - 1];
		}

		static int dfs(int[][] dp, int m, int n){
			if(m < 0 ||  n < 0){
				return 0;
			}
			else if( m == 0 || n == 0){
				return 1;
			}
			else if(dp[m][n] > 0){
				return dp[m][n];
			}
			else{
				dp[m][n] = dfs(dp, m, n - 1) + dfs(dp, m - 1, n);
				return dp[m][n];
			}
		}

	public static void main(String[] args) {
		int result = uniquePaths(3,3);
		System.out.println(result);
	}
}
