class Solution {
    public int[] sumZero(int n) {
        if(n==0)
            return new int[]{};
        int[] result=new int[n];
        int sum=0;
        for(int i=0;i<n-1;i++){
            result[i]=i+1;
            sum+=result[i];
        }
        result[result.length-1]=-sum;
        return result;
    }
}
