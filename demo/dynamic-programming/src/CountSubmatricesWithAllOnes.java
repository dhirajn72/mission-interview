import java.util.Arrays;

public class CountSubmatricesWithAllOnes {
	static public int numSubmat(int[][] mat) {
		int n=mat.length;
		int m=mat[0].length;

		int[][] dp=new int[n][m];
		for(int i=0;i<n;i++){
			int count=0;
			for(int j=0;j<m;j++){
				if(mat[i][j]==1)
					count++;
				else
					count=0;

				dp[i][j]=count;
			}
		}
		System.out.println(Arrays.deepToString(dp));
		int res=0;
		for(int i = 0;i < n; i++){
			for (int j = 0; j < m; j++) {
				int min=Integer.MAX_VALUE;
				for(int k=i;k<n;k++){
					min=Math.min(dp[k][j],min);
					res += min;
					//System.out.println(res);
				}
			}
		}
		System.out.println(Arrays.deepToString(dp));
		return res;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,0,1},{1,1,0},{1,1,0}};
		int res = numSubmat(matrix);
		System.out.println(res);
	}
}
