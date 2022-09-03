import java.util.Arrays;

public class MaxIceCream {
	static public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		for(int i = 0; i < costs.length; i++){
			if(coins >= costs[i]){
				coins -= costs[i];
			}
			else
				return i;
		}
		return costs.length;
	}

	public static void main(String[] args) {
		int[] costs = {1,3,4,2,1};
		System.out.println(maxIceCream(costs, 7));
	}
}
