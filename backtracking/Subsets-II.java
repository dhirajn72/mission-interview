class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
       Arrays.sort(nums);
       backtrack(nums,new ArrayList<>(),0);
       return result;
   }
   void backtrack(int[] nums,List<Integer> list,int start){
       result.add(new ArrayList<>(list));
       for(int i=start;i<nums.length;i++){
           if(i>0 && nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
       }
   }
}
