class Solution {
    public int twoEggDrop(int n) {
        
        int floor=1;
        boolean flag=true;
        int[] dp=new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(floor>n){
                    flag=false;
                    break;
                }
                dp[floor]=i;
                floor++;
            }
            if(!flag)
                break;
        }
        return dp[n];
    }
}
