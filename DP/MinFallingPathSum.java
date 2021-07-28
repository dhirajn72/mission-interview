class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int min=Integer.MAX_VALUE;
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(j==0){
                    matrix[i][j]+=Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                }
                else if(j==matrix[i].length-1){
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],matrix[i-1][j]);
                }
                else{
                    matrix[i][j]+=Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],matrix[i-1][j+1]));
                }
            }
        }
        for(int e:matrix[matrix.length-1]){
            min=Math.min(min,e);
        }
        return min;
    }
}
