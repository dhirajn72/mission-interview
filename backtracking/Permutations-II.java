class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        permute(nums,0);
        return result;
    }
    void permute(int[] nums,int i){
        if(i==nums.length){
            List<Integer> res=new ArrayList<>();
            for(int e:nums)
                res.add(e);
            if(!result.contains(res))
                result.add(res);
        }
        else{
            for(int j=i;j<nums.length;j++){
                swap(nums,i,j);
                permute(nums,i+1);
                swap(nums,i,j);
            }
        }
    }
    void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
