class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result=new int[m][n];
        int index=0;
        int num=m*n;
        if(num<original.length || num>original.length)
            return new int[][]{};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=original[index++];
            }
        }
        return result;
    }
}
