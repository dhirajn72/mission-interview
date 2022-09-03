
class Solution {
    public boolean isSubsequence(String s, String t) {
        int m=s.length()-1;
        int n=t.length()-1;
        
        int[][] matrix=new int[m+1][n+1];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<t.length();j++){
                if(s.charAt(i)==t.charAt(j)){
                    matrix[i+1][j+1]=matrix[i][j]+1;
                }
                else{
                    matrix[i+1][j+1]=Math.max(matrix[i][j+1],matrix[i+1][j]);
                }
            }
        }
        System.out.println(Arrays.deepToString(matrix));
        return matrix[m][n]==s.length();
    }
}

