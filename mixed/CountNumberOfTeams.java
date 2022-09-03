class Solution {
    public int numTeams(int[] rating) {
        if(rating==null || rating.length==0)
            return 0;

        int n=rating.length;
        int[] dp=new int[n];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(rating[i]>rating[j]){
                    dp[i]++;
                    count=count+dp[j];
                }
            }
        }
        dp=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i;j>=0;j--){
                if(rating[i]<rating[j]){
                    dp[i]++;
                    count=count+dp[j];
                }
            }
        }
        return count;
    }
}
