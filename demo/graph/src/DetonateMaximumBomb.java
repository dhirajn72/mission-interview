public class DetonateMaximumBomb {
	static int count = 0; // global variable, otherwise use an array
	static public int maximumDetonation(int[][] bombs) {
		int n = bombs.length;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			count = 0; // Start a new search, reset count
			dfs(i, new boolean[n], bombs);
			ans = Math.max(ans, count);
		}
		return ans;
	}

	static private void dfs(int idx, boolean[] v, int[][] bombs) {
		count++;
		v[idx] = true;
		int n = bombs.length;
		for (int i = 0; i < n; i++) {
			if (!v[i] && inRange(bombs[idx], bombs[i])) {
				v[i] = true;
				dfs(i, v, bombs);
			}
		}
	}

	static private boolean inRange(int[] a, int[] b) {
		long dx = a[0] - b[0], dy = a[1] - b[1], r = a[2];
		return dx * dx + dy * dy <= r * r;
	}

	public static void main(String[] args) {
		//int[][]  bombs = {{2,1,3},{6,1,4}};
		int[][] bombs = {{1,2,3},{2,3,1},{3,4,2},{4,5,3},{5,6,4}};
		System.out.println(maximumDetonation(bombs));

	}
}
