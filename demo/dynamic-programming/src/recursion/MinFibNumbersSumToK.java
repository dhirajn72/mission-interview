package recursion;

public class MinFibNumbersSumToK {
	static public int findMinFibonacciNumbers(int k) {
		if (k < 2) return k;
		int first = 1, second = 1;
		while (second <= k) { // This loop will only terminate when value of second will be more than K, so don't need to consider the value of second
			second = first + second;
			first = second - first;
		}
		return 1 + findMinFibonacciNumbers(k - first); // subtract first from k, because value of second is more than k, and second is of no use.
	}

	public static void main(String[] args) {
		System.out.println(findMinFibonacciNumbers(11));
	}
}
