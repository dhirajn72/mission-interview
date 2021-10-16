class Solution {
    public int minimumDeletions(String s) {
        int result=0;
        if(s==null||s.length()==0)
            return result;
        int n=s.length();
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='a'){
                dp[i+1]=Math.min(dp[i]+1,bcount);
            }
            else{
                dp[i+1]=dp[i];
                bcount++;
            }
        }
        return dp[n];
    }
}
