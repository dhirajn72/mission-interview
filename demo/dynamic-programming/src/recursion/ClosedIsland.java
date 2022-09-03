package recursion;

public class ClosedIsland {
	static int result;
	public static int closedIsland(int[][] grid) {
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					result += dfs(grid, i, j);
				}
			}
		}
		return result;
	}

	static int dfs(int[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length)
			return 0;
		if (grid[i][j] == 1) return 1;
		grid[i][j] = 1;
		int down = dfs(grid, i + 1, j);
		int up = dfs(grid, i - 1, j);
		int left = dfs(grid, i, j + 1);
		int right = dfs(grid, i, j - 1);
		int result = up & down & left & right;
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,1,1,1,1,1,1,0},
						  {1,0,0,0,0,1,1,0},
				          {1,0,1,0,1,1,1,0},
				          {1,0,0,0,0,1,0,1},
				          {1,1,1,1,1,1,1,0}};
		int result = closedIsland(matrix);
		System.out.print(result);
		System.out.println();

		/*System.out.println(4 & 5);
		System.out.println(0 & 1);
		System.out.println(0 | 1);
		System.out.println(1 | 1);
		 */
	}
}
