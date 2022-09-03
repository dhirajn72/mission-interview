public class LongestIncreasingPath {
	static int[][] directions = {{1, 0},{-1, 0},{0, -1},{0, 1}};
	static public int longestIncreasingPath(int[][] matrix) {
		int[][] dp = new int[matrix.length][matrix[0].length];
		int result = 0;
		for(int i = 0; i < matrix.length; i++ ){
			for(int  j = 0; j < matrix[0].length; j++){
				int max = largestPath(matrix, i, j, dp);
				result = Math.max(result, max);
			}
		}
		return result;
	}
	static int largestPath(int[][] graph, int i, int j, int[][] dp){
		if(dp[i][j] > 0){
			return dp[i][j];
		}
		int res = 0;
		for(int[] direction : directions){
			int x = i + direction[0];
			int y = j + direction[1];
			if(x >= 0 && y >=0 && x < graph.length && y < graph[0].length && graph[x][y] > graph[i][j] ){
				int max = largestPath(graph, x, y, dp);
				res = Math.max(res, max);
			}
		}
		return dp[i][j] = res + 1;
	}

	public static void main(String[] args) {
		int[][]  matrix = {{9,9,4},{6,6,8},{2,1,1}};
		int res = longestIncreasingPath(matrix);
		System.out.println(res);
	}
}







