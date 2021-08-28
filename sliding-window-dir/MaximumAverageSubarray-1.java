class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n=nums.length;
        if(n==1)
            return nums[0];
        double result=Double.MIN_VALUE;
        for(int i=0;i<n-k+1;i++){
            double sum=0;
            for(int j=0;j<k;j++){
                sum+=nums[i+j];
            }
            result=Math.max(result,sum/k);
        }
        return result;
    }
}
