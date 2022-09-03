class FindTheDifference{
    public char findTheDifference(String s, String t) {
        int[] dp=new int[123];
        for(int i=0;i<s.length();i++){
            dp[s.charAt(i)]= ++dp[s.charAt(i)];
        }
        for(int i=0;i<t.length();i++){
            dp[t.charAt(i)] = --dp[t.charAt(i)];
        }
        for(int i=0;i<t.length();i++){
            if(dp[t.charAt(i)]!=0)
                return t.charAt(i);
        }
        return '\0';

        /*char[] sArr=s.toCharArr();
        char[] tArr=t.toCharArr();
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i=0;i<s.length();i++){
            if(sArr[i]!=tArr[i])
                return tArr[i];
        }
        return '\0';*/
    }
}
