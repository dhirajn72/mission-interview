class Solution {
    int max=0;
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null ||matrix.length==0 ||matrix[0].length==0)
            return max;
        int n=matrix.length;
        int m=matrix[0].length;

        int[][] dp=new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dp[i][j]=Integer.valueOf(matrix[i][j]+"");

        for(int i=1;i<n;i++){
            for(int j=0;j<m;j++){
                if(dp[i][j]!=0){
                    dp[i][j] += dp[i-1][j]; 
                }
            }
        }
        for(int[] row:dp)
            histogram(row);
        return max;
    }
    void histogram(int[] arr){
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=i;j<arr.length;j++){
                if(arr[j]>=arr[i])
                    count++;
                else
                    break;
            }
            for(int j=i-1;j>=0;j--)
                if(arr[j]>=arr[i])
                    count++;
                else
                    break;
            max=Math.max(max,count*arr[i]);
        }
    }
}
