class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if(arr==null||arr.length==0)
            return 0;
        int n=arr.length;
        if(n<k)
            return 0;
        int result=0;
        for(int i=0;i<n-k+1;i++){
            int sum=0;
            for(int j=0;j<k;j++){
                sum+=arr[i+j];
            }
            if(sum/k >= threshold)
                result++;
        }
        return result;
        
    }
}
