import java.util.Arrays;

public class MaximumCoinsGreedy {
	static public int maxCoins(int[] piles) {
		Arrays.sort(piles);
		int result = 0;
		for(int i = piles.length / 3; i < piles.length; i += 2){
			result += piles[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] coins = {9,8,7,6,5,1,2,3,4};
		System.out.println(maxCoins(coins));
	}
}
