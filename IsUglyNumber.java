class Solution {
    public boolean isUgly(int n) {
        //This solution is correct but throws with TLE
        /*if(n==0 || n<0)
            return false;
        int i2=0,i3=0,i5=0;
        int ni2=2,ni3=3,ni5=5;
        int[] dp=new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int next=Math.min(ni2,Math.min(ni3,ni5));
            dp[i]=next;
            if(next==ni2){
                i2++;
                ni2=dp[i2]*2;
            }
            if(next==ni3){
                i3++;
                ni3=dp[i3]*3;
            }
            if(next==ni5){
                i5++;
                ni5=dp[i5]*5;
            }
        }
        for(int e:dp)
            if(e==n)
                return true;
        return false;
        */

        // This is accepted solution.
        if(n==0 || n<0)
            return false;
        while(n!=1){
            if(n%2==0)
                n = n/2;
            else if(n%3==0)
                n = n/3;
            else if(n%5==0)
                n = n/5;
            else 
                return false;
        }
        return true;
    }
}
