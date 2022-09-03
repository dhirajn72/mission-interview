package knapsack;

public class TwoKeysKeyboard {
	static public int minSteps(int n) {
		int[] dp = new int[n + 1];
		for(int i = 2; i <= n; i++){
			dp[i] = i;
			for(int j = i - 1; j >= 1; j--){
				if(i % j == 0){ // This condition means, the previous stored values of j can be used to calculate the current ith index
					dp[i] = dp[j] + (i / j);
					break; // Why this break ? Because, once copied to dp[i], we're not going to modify it for the same jth index
				}
			}
		}
		return dp[n];
	}
	public static void main(String[] args) {
		System.out.println(minSteps(2));
		System.out.println(minSteps(5));
		System.out.println(minSteps(10));
	}
}
