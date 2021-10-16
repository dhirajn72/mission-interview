//TODO: This solution passes for small inputs.
class Solution {
    long max=Long.MIN_VALUE;
    public int kConcatenationMaxSum(int[] arr, int k) {
        if(arr==null)
            return 0;
        int n=arr.length;
        int l=n*k;
        int[] newArr=new int[l];
        l=k;
        int index=0;
        while(l>0){
            for(int i=0;i<arr.length;i++){
                newArr[index]=arr[i];
                index++;
            }
            l--;
        }
        int[] dp=new int[newArr.length];
        dp[0]=newArr[0];
        for(int i=1;i<newArr.length;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+newArr[i];
            }
            else{
                dp[i]=newArr[i];
            }
        }
        for(int e:dp){
            max=Math.max(max,e);
        }
       return (int) max>0 ? max:0;
    }
}
/*
[-1,-2]
7


[-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2,-1,-2]




*/
