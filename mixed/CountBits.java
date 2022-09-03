class Solution {
    public int[] countBits(int n) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(getOnes(i));
        }
        int[] res=new int[list.size()];
        int index=0;
        for(int i:list){
            res[index++]=i;
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
