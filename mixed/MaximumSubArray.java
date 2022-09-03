class Solution {
    public int maxSubArray(int[] nums) {
        if(nums==null)        
            return 0;
        if(nums.length==1)
            return nums[0];

        int max=Integer.MIN_VALUE;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum=Math.max(nums[i],nums[i]+sum);
            max=Math.max(sum,max);
        }
        return max;
    }
}
