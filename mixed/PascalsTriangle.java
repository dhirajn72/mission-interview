class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> generate(int numRows) {
        int[][] matrix=new int[numRows][numRows];

        for(int i=0;i<numRows;i++){
            matrix[i][0]=1;
            matrix[i][i]=1;
        }
        for(int i=2;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                matrix[i][j]=matrix[i-1][j-1]+matrix[i-1][j];
            }
        }

        for(int i=0;i<matrix.length;i++){
            List<Integer> list=new ArrayList<>();
            for(int j=0;j<=i;j++){
                list.add(matrix[i][j]);
            }
            result.add(list);
        }
        System.out.println(Arrays.deepToString(matrix));
        return result;
    }
}
