public class LargestSubmatrixWithArrangement {
	class Solution {
		public int largestSubmatrix(int[][] matrix) {
			for(int[] row:matrix) {
				int index=0,j=0;
				while (j<row.length){
					if(row[j]==1) {
						row[index++] = 1;
					}
					j++;
				}
			}
			int area=0;
			for(int i=1;i<matrix.length;i++) {
				for(int j=1;j<matrix[i].length;j++) {
					if (matrix[i-1][j]==1 && matrix[i][j-1]==1 && matrix[i-1][j-1]==1) {
						area=(i+1)*2;
					}
				}
			}
			return area;
		}
	}
}
