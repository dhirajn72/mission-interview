class Solution {
    int res=0;
    public int findTargetSumWays(int[] nums, int target) {
        findTarget(nums,0,0,target);
        return res; 
    }
    void findTarget(int[] nums,int i,int sum,int target){
        if(i==nums.length){
            if(sum==target)
                res++;
        }
        else{
            findTarget(nums,i+1,sum+nums[i],target);
            findTarget(nums,i+1,sum-nums[i],target);
        }
    }
}

// 1 < logn < √n < n < nlogn < n square < n cube < 2 power n < n!

