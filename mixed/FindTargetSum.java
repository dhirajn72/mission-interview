class Solution {
    int result=0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums==null||nums.length==0)
            return result;

        findTargetSumWays(nums,0,0,target);
        return result;
    }
    void findTargetSumWays(int[] nums,int i,int sum,int target){
        if(i==nums.length){
            if(sum==target)
                result++;
            return;
        }
        else{
            findTargetSumWays(nums,i+1,sum+nums[i],target);
            findTargetSumWays(nums,i+1,sum-nums[i],target);
        }
    }
}
