class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        if(matrix==null||matrix.length==0)
            return new ArrayList<>();
        List<Integer> result=new ArrayList<>();
        int r=matrix.length-1;
        int c=matrix[0].length-1;

        int min=Integer.MAX_VALUE;
        int j=0;
        for(int i=0;i<1;i++){
            int minIndex=0;
            for(j=0;j<c;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                    minIndex=j;
                }
            }
            for(j=0;j<r;j++){
                if(min>=matrix[j][minIndex]){
                    min=matrix[j][minIndex];
                }
            }
        }
        boolean flag=j==r;
        int k=j;
        int temp=min;
        min=integer.max_value;
        for(int i=r;i<matrix.length;i++){
            int minIndex=0;
            for(j=0;j<c;j++){
                if(matrix[i][j]<min){
                    min=matrix[i][j];
                    minIndex=j;
                }
            }
            for(j=r;j>=0;j--){
                if(min>=matrix[j][minIndex]){
                    min=matrix[j][minIndex];
                }
            }
        }
        if(flag && j>0)
          result.add(temp);
        else
            result.add(min);
        return result;
    }
}
