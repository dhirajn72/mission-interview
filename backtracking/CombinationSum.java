class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtrack(candidates,new ArrayList<>(),0,target);
        return result;
    }
    void backtrack(int[] nums,List<Integer> list,int start,int target){
        int sum=0;
        for(int e:list){
            sum+=e;
        }
        if(sum==target){
            result.add(new ArrayList<>(list));
            return;
        }
        if(sum>target)
            return ;
        else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);
                backtrack(nums,list,i+1,target);
                list.remove(list.size()-1);
            }
        }
    }

}
