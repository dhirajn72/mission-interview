public class LongestValidParanthesis {
	static public int longestValidParentheses(String s) {
		int[] dp = new int[s.length()];
		int result = 0;
		int leftCount = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				leftCount++;
			}
			else if (leftCount > 0){
				dp[i] = dp[i - 1] + 2;
				if(i - dp[i] > 0)
					dp[i] += dp[i - dp[i]];

				result = Math.max(result, dp[i]);
				leftCount--;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		String str = "()(((()))";
		System.out.println(longestValidParentheses(str));
	}
}
