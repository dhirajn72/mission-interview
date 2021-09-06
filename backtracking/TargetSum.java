class Solution {
    int result=0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,0,0,target);
        return result;
    }
    void backtrack(int[] nums,int i,int sum,int target){
        if(i==nums.length){
            if(sum==target)
                result++;
        }
        else{
            backtrack(nums,i+1,sum+nums[i],target);
            backtrack(nums,i+1,sum-nums[i],target);
        }
    }
}
