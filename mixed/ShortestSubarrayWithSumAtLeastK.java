class Solution {
    public int shortestSubarray(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==k || nums[i]>k)
                return 1;
        }
        int n=nums.length;
        
        for(int i=0;i<n-k+1;i++){
            for(int j=0;j<n;j++){
                int sum=arr[i+j];
                if(sum==k||sum>k)
                    return i+j;
            }
        }
        return -1;
    }
}
