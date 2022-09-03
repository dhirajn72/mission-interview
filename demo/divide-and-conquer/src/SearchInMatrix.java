public class SearchInMatrix {
	static public boolean searchMatrix(int[][] matrix, int target) {
		int i=0;
		int j=matrix[0].length-1;
		while(i>=0 && i<matrix.length && j>=0 && j<matrix[i].length){
			int val=matrix[i][j];
			if(val<target){
				i++;
			}
			else if(val>target){
				j--;
			}
			//System.out.println(matrix[i][j]);
			if(val==target)
				return true;
		}
		return false;

	}
	public static void main(String[] args){
		int[][] arr={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		int target= 9;
		searchMatrix(arr,target);
	}
	/*
	[1, 4, 7, 11,15]
	[2, 5, 8, 12,19]
	[3, 6, 9, 16,22]
	[10,13,14,17,24]
	[18,21,23,26,30]
	 */
}
