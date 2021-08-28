class Solution {
    int res=0;
    public int countSubstrings(String s) {
        if(s==null||s.length()==0)
            return res;
        int n=s.length();
        boolean[][] dp=new boolean[n][n];
        for(int i=0;i<n;i++){
            dp[i][i]=true;
            res++;
        }
        for(int i=1;i<n;i++){
            if(s.charAt(i)==s.charAt(i-1)){
                dp[i-1][i]=true;
                res++;
            }
        }
        for(int i=3;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                if(s.charAt(j)==s.charAt(k) && dp[j+1][k-1]){
                    dp[j][k]=true;
                    res++;
                }
            }
        }
        return res;
    }
}
