class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        if(nums==null||nums.length==0)
            return 0;
        Arrays.sort(nums);       
        int result=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=lower && nums[i]<=upper){
                result+=nums[i];
            }
        }
        return result;
    }
}
