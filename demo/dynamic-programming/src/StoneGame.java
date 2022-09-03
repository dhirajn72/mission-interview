import java.util.Arrays;

public class StoneGame {
	static public boolean stoneGame(int[] piles) {
		int[][] dp = new int[piles.length][piles.length];
		for(int i = 1; i < piles.length; i++){
			for(int j = 0; j < piles.length - i; j++){
				int k = i + j;

				int leftStone = piles[j] - dp[j + 1 ][k];
				int rightStone = piles[k] - dp[j][k - 1];
				dp[i][j] = Math.max(leftStone, rightStone);
			}
		}
		for(int[] row : dp)
		System.out.println(Arrays.toString(row));
		return dp[0][piles.length - 1] == 0;
	}

	public static void main(String[] args) {
		int[] stones = {5,3,9,5};
		System.out.println(stoneGame(stones));
	}
}
