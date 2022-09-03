class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int result=0;
        if(arr==null||arr.length==0)
            return result;
        int n=arr.length;
        int[][] dp=new int[n][n];
        for(int i=1;i<n;i++){
            int l=0;
            int r=i-1;
            while(l<r){
                int sum=arr[l]+arr[r];
                if(sum<arr[i]){
                    l++;
                }
                else if(sum > arr[i]){
                    r--;
                }
                else{
                    dp[r][i] = dp[l][r]+1;
                    result=Math.max(result,dp[l][r]);
                    l++;
                    r--;
                }
            }
        }
        return result==0?result:result+2;
    }
}
