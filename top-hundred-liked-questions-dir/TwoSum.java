class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> dp=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            dp.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int find=target-nums[i];
            if(dp.containsKey(find) && dp.get(find)!=i)
                return new int[]{i,dp.get(find)};
        }
        return null;    
    }
}
