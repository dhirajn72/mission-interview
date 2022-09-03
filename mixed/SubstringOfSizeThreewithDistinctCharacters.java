class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length()-1;
        int[] dp=new int[130];
        boolean flag=false;
        int count=0;
        for(int i=0;i<=n-2;i++){
            String sub=s.substring(i,i+3);
            for(int j=0;j<sub.length();j++){
                if(dp[sub.charAt(j)]==0){
                    dp[sub.charAt(j)]=1;
                }
                else
                    dp[sub.charAt(j)] +=1;

                if(dp[sub.charAt(j)]>1){
                    flag=true;
                    break;
                }
                
            }
            if(!flag){
                count++;
                flag=false;
                Arrays.fill(dp,0);
            }
        }
        return count;
    }
}
