public class CountPalindromicSubstrings {
	static public int countSubstrings(String s) {
		int n = s.length();
		if( n == 1 )
			return 1;
		boolean[][] dp = new boolean[n][n];
		int result = 0;
		for(int i = 0; i < s.length(); i++){
			for(int j = i ; j < s.length(); j++){
				if(dfs(s, dp, i, j)){
					result++;
				}
			}
		}
		return result;
	}
	static boolean dfs(String s, boolean[][] dp, int start, int end){
		if(start == end)
			return true;
		if(dp[start][end] == false){
			if(s.charAt(start) == s.charAt(end)){
				if(end - start <= 2){
					dp[start][end] = true;
				}
				else
					dp[start][end] = dfs(s, dp, start + 1, end - 1);
			}
		}
		return dp[start][end];
	}

	public static void main(String[] args) {
		System.out.println(countSubstrings("abbc"));
	}
}
