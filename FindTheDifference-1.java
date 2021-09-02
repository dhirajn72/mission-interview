class Solution {
    public char findTheDifference(String s, String t) {
        if(s==null||s.length()==0)
            return t.charAt(0);

        int[] dp=new int[123];
        for(int i=0;i<s.length();i++){
            dp[s.charAt(i)] = ++dp[s.charAt(i)];
        }
        for(int i=0;i<t.length();i++){
            dp[t.charAt(i)] = --dp[t.charAt(i)];
        }
        for(int i=0;i<t.length();i++){
            if(dp[t.charAt(i)]!=0){
                return t.charAt(i);
            }
        }
        return ' ';
    }
}
