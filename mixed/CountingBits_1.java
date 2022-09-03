class Solution {
    public int[] countBits(int n) {
        if(n==0)
            return new int[]{0};
        int[] result=new int[n+1];
        int index=0;
        for(int i=0;i<=n;i++){
            int ones=getOnes(i);
            result[index++]=ones;
        }
        return result;
    }
    int getOnes(int n){
        int ones=0;
        while(n!=0){
            ones=ones+n%2;
            n=n/2;
        }
        return ones;
    }
}
