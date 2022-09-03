class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null)
            return 0;
        Arrays.sort(nums);
        if(nums.length>=2)
            return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
        return nums[0];
    }
}
