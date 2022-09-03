import java.util.Arrays;

public class UpdateMatrix {
	static public int[][] updateMatrix(int[][] mat) {
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				if(mat[i][j] != 0){
					update(mat, i , j);
				}
			}
		}
		return mat;
	}
	static int update(int[][] matrix, int i, int j){
		if(i < 0 || j < 0)
			return Integer.MAX_VALUE;
		if(i >= matrix.length || j >= matrix[0].length)
			return Integer.MAX_VALUE;
		if(matrix[i][j] == 0)
			return 1;

		int up = update(matrix, i + 1, j);
		int down = update(matrix, i - 1, j );
		int left = update(matrix, i, j + 1 );
		int right = update(matrix, i, j - 1);
		int min = Math.min(up, down );
		matrix[i][j] += Math.min(min, Math.min(left, right));
		return matrix[i][j];
	}

	public static void main(String[] args) {
		//int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
		//int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
		int[][] arr = {{0,0,0},{0,1,0},{1,1,1}};
		updateMatrix(arr);
		System.out.println(Arrays.deepToString(arr));


	}
}
