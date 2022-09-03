import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CatalanNumber {
	Map<Integer, Integer> dp = new HashMap<>();

	// Driver Code
	public static void main(String[] args) {
		CatalanNumber cn = new CatalanNumber();
		for (int i = 0; i < 10; i++) {
			System.out.print(cn.catalan(i) + " ");
		}
		System.out.println(cn.catalan(5));
	}

	int catalan(int n) {
		if (dp.containsKey(n)) return dp.get(n);

		int res = 0;
		// Base case
		if (n <= 1) {
			return 1;
		}
		for (int i = 0; i < n; i++) {
			res += catalan(i) * catalan(n - i - 1);

		}
		dp.put(n, res);
		return res;
	}
}
/*
1 1 2 5 14 42 132 429 1430 4862
1 1 2 5 14 42 132 429 1430 4862


 */
