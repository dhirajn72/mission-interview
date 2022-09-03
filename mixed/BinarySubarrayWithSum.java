class Solution {
    int result=0;
    public int numSubarraysWithSum(int[] nums, int goal) {
        if(nums==null||nums.length==0)
            return result;
        int n=nums.length;
        for(int i=0;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                int sum=0;
                for(int l=j;l<=k;l++){
                    sum+=nums[l];
                }
                if(sum==goal)
                    result++;
            }
        }
        return result;
    }
}
