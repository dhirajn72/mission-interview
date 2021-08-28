class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix==null||matrix.length==0||matrix[0]==null||matrix[0].length==0)
            return 0;
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=Integer.valueOf(matrix[i][j]+"");
            }
        }
        int result=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 ){
                    if(arr[i][j]==1){
                        result=Math.max(result,1);
                    }
                    continue;
                }
                if(arr[i][j]!=0){
                    arr[i][j] += Math.min(arr[i-1][j-1],Math.min(arr[i-1][j],arr[i][j-1]));
                    result=Math.max(result,arr[i][j]);
                }
            }
        }
        return result*result;
    }
}
