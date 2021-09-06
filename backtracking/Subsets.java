class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums,new ArrayList<>(),0);
        return result;
    }
    void backtrack(int[] nums,List<Integer> res,int start){
        result.add(new ArrayList<>(res));
        for(int i=start;i<nums.length;i++){
            res.add(nums[i]);
            backtrack(nums,res,i+1);
            res.remove(res.size()-1);
        }
    }
}
