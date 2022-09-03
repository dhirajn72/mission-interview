class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int res=0,count=0;
        if(nums==null || nums.length==0)
            return res;

        for(int i=2;i<nums.length;i++){
            if(nums[i]-nums[i-1]==nums[i-1]-nums[i-2]){
                count++;
                res+=count;
            }
            else{
                count=0;
            }
        }
        return res;
    }
}
