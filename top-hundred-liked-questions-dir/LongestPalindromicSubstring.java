class Solution {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0)
            return s;

        int n=s.length();
        int start=0,max=0;
        boolean[][]  matrix=new boolean[n][n];
        for(int i=0;i<n;i++){
            matrix[i][i]=true;
            max=1;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                matrix[i][i+1]=true;
                start=i;
                max=2;
            }
        }
        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(s.charAt(j)==s.charAt(k) && matrix[j+1][k-1]){
                    matrix[j][k]=true;
                    if(i>max){
                        start=j;
                        max=i;
                    }
                }
            }
        }
        return s.substring(start,start+max);

    }
}
