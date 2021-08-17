class Solution {
    public char findTheDifference(String s, String t) {
        if(s==null|| s.length()==0)
            return t.charAt(0);
        int n=s.length();
        int[] dp=new int[130];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            dp[c]=dp[c]+1;
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            dp[c]=dp[c]-1;
        }
        System.out.println(Arrays.toString(dp));
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            if(dp[c]!=0){
                return c;
            }
        }
        return ' ';
    }
}
