class Solution {
    List<Integer> list=new ArrayList<>();
    public int[] shuffle(int[] nums, int n) {
        if(nums==null||nums.length==0 ||n==0)
            return nums;
        
        int length=nums.length-1;
        for(int i=0;i<=length-n;i++){
            list.add(nums[i]);
            list.add(nums[i+n]);
        }
        int index=0;
        for(int e:nums){
            nums[index++]=e;
        }
        return nums;
    }
}
