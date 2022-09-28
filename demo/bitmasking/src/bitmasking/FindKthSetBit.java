package bitmasking;

public class FindKthSetBit {
	public static void isKthBitSet(int n, int k) {
		if ((n & (1 << (k - 1))) > 0)
			System.out.print("SET");
		else
			System.out.print("NOT SET");
	}

	static int setKthBit(int n, int k) {
		return (1 << k) | n;
	}

	static void printKthBit(long n, long k) {
		System.out.println(((n & (1 << (k - 1))) >> (k - 1)));
	}

	// Driver code
	public static void main(String[] args) {
		int n = 2, k = 3;

		// Function call
		isKthBitSet(n, k);
		System.out.println(setKthBit(n, k));
		printKthBit(2, 3);
		printKthBit(10, 2);
	}

}
