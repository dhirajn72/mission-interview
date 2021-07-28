class Solution {
    public int[] countBits(int num) {
        if(num==0)
            return new int[]{};
        int[] res=new int[num+1];
        int index=1;
        for(int i=0;i<=num;i++){
            res[index++]=getOnes(i);
        }
        return res;
    }

    int getOnes(int n){
        int ones=0;
        while(n>0){
            ones+=n%2;
            n=n/2;
        }
        return ones;
    }
}
