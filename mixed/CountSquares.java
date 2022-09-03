class Solution {
    public int countSquares(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;

        int n=matrix.length;
        int m=matrix[0].length;
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==0)
                    continue;
                if(i==0||j==0){
                    result++;
                    continue;
                }
                if(matrix[i-1][j-1]!=0 && matrix[i-1][j]!=0 && matrix[i][j-1]!=0){
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i][j-1]));
                    result+=matrix[i][j];
                }
                else{
                    result++;
                }
            }
        }
        return result;
    }
}
