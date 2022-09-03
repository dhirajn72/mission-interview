class Solution {
    public int firstUniqChar(String s) {
        int[] dp=new int[123];
        for(int i=0;i<s.length();i++){
            dp[s.charAt(i)]=++dp[s.charAt(i)];
        }
        for(int i=0;i<s.length();i++){
            if(dp[s.charAt(i)]==1)
                return i;
        }
        return -1;
    }
}
