class Solution {
    public int twoEggDrop(int n) {
        int c=1;
        int[] dp=new int[n+1];
        boolean flag=true;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=i;j++){
                if(c>n){
                    flag=false;
                    break;
                }
                dp[c]=i;
                c++;
           }
            if(!flag)
                break;
 
        }
        return dp[n];
       
    }
}
