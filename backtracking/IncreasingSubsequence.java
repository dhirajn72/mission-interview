class Solution {
    Set<List<Integer>> result=new HashSet<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        if(nums==null||nums.length==0)
            return new ArrayList<>(result);
        backtrack(nums,new ArrayList<>(),0);
        return new  ArrayList<>(result);
    }
    void backtrack(int[] nums,List<Integer> list,int start){
        if(list.size()>1)
            result.add(new ArrayList<>(list));
        for(int i=start;i<nums.length;i++){
            if(list.size()==0 || nums[i]>=list.get(list.size()-1)){
                list.add(nums[i]);
                backtrack(nums,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
