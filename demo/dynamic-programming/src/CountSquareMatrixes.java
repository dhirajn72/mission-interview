import java.util.Arrays;

public class CountSquareMatrixes {
	static int result = 0;
	static public int countSquares(int[][] matrix) {
        /*
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) continue;
                matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i][j - 1]));
            }
        }
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                result += matrix[i][j];
            }
        }
        return result;
        */
		System.out.println(Arrays.deepToString(matrix));
		boolean[][] dp = new boolean[matrix.length][matrix[0].length];
		dfs(matrix, matrix.length - 1, matrix[0].length - 1, dp);
		for(int i = 0; i < matrix.length; i++){
			for(int j = 0; j < matrix[0].length; j++){
				result += matrix[i][j];
			}
		}
		System.out.println(Arrays.deepToString(matrix));
		return result;
	}

	static int dfs(int[][] matrix, int i, int j, boolean[][] dp){
		if(i < 0 || i == matrix.length) return 0;
		if(j < 0 || j == matrix[0].length) return 0;
		if(dp[i][j])
			return matrix[i][j];

		if(i == 0 || j == 0) {
			dp[i][j] = true;
			return matrix[i][j];
		}

		/*
		if(matrix[i][j] > 1) {
			dp[i][j] = true;
			return matrix[i][j];
		}
		 */

		matrix[i][j] += Math.min(dfs(matrix, i - 1, j - 1, dp), Math.min(dfs(matrix, i - 1, j, dp), dfs(matrix, i, j - 1, dp)));
		dp[i][j] = true;
		return matrix[i][j];
	}

	public static void main(String[] args) {
		//int[][] matrix = {{0,1,1,1},{1,1,1,1},{0,1,1,1}};
		int[][] matrix = {{0,0,0},{0,1,0},{0,1,0},{1,1,1},{1,1,0}};
		System.out.println(countSquares(matrix));
	}
}
