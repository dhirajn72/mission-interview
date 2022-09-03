import java.util.Arrays;

public class ParkTheBall {
	/**
	 * This is incomplete implementation, don't refer this.
	 */
		static public int[] findBall(int[][] grid) {
			int[][] dp = new int[grid.length][grid.length];
			for(int[] row : dp){
				Arrays.fill(row, Integer.MAX_VALUE);
			}
			Arrays.fill(dp[0], 0);
			for(int i = 1; i < grid.length; i++){
				for(int j = 0; j < grid[i].length; j++){
					if(j == 0 ){
						if(grid[i - 1][j + 1] == -1 && dp[i - 1][j + 1] != Integer.MAX_VALUE){
							dp[i][j] = j + 1;
						}
					}
					else if(j == grid[i].length - 1 ){
						if(grid[i - 1][j - 1] == 1 && dp[i - 1][j - 1] != Integer.MAX_VALUE){
							dp[i][j] = j ;
						}
					}
					else if(grid[i - 1][j - 1] == 1 && grid[i - 1][j + 1] == -1 ){
						if(dp[i - 1][j - 1] != Integer.MAX_VALUE  || dp[i - 1][j + 1] != Integer.MAX_VALUE){
							dp[i][j] = j ;
						}
					}
				}
			}
			//System.out.println(Arrays.toString(dp[dp.length - 1]));
			return dp[dp.length - 1];
		}

	public static void main(String[] args) {
		int[][] grid = {{1,1,1,-1,-1},{1,1,1,-1,-1},{-1,-1,-1,1,1},{1,1,1,1,-1},{-1,-1,-1,-1,-1}};
		System.out.println(Arrays.toString(findBall(grid)));

	}
/*

[ 1, 1, 1,-1,-1]
[ 1, 1, 1,-1,-1]
[-1,-1,-1, 1, 1]
[ 1, 1, 1, 1,-1]
[-1,-1,-1,-1,-1]



*/
}
