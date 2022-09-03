class Solution {
    public int maxPower(String s) {

        int[] dp=new int[arr.length()];
        int result=1;
        for(int i=0;i<dp.length;i++)
            dp[i]=1;

        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                dp[i]=Math.max(dp[i],dp[i-1]+dp[i]);
                result=Math.max(result,dp[i]);
            }
        }
        return result;
    }
}
