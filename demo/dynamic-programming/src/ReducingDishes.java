import java.util.Arrays;

public class ReducingDishes {
	static public int maxSatisfaction(int[] satisfaction) {
		int total = 0, result = 0;
		Arrays.sort(satisfaction);
		for(int i = satisfaction.length - 1; i >= 0 && satisfaction[i] > -total; i--){
			total += satisfaction[i];
			result += total;
		}
		return result;
	}
	public static void main(String[] args){
		int[] satisfactions = {-1, -8, 0, 5, -9};
		System.out.println(maxSatisfaction(satisfactions));
	}
}
