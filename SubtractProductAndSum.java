class Solution {
    public int subtractProductAndSum(int n) {
        if(n==0)
            return 0;
        int mul=0;
        int k=n;
        while(n!=0){
            mul*=n%10;
            n/=10;
        }
         int sum=0;
         while(k!=0){
            sum+=k%10;
            k/=10;
         }
        return mul-sum;
    }
}
