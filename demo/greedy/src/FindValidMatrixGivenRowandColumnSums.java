
public class FindValidMatrixGivenRowandColumnSums {
	class Solution {
		public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int[][] result=new int[rowSum.length][colSum.length];
            for(int i=0;i<rowSum.length;i++){
                for(int j=0;j<colSum.length;j++){
                    result[i][j]=Math.min(rowSum[i],colSum[j]);
                    rowSum[i] -= result[i][j];
                    colSum[j] -= result[i][j];
                }
            }
            return result;
		}
	}
}
