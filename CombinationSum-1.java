class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       Arrays.sort(candidates);
       combinationSum(candidates,new ArrayList<>(),target,0);
       return result;
    }
    void combinationSum(int[] candidates,List<Integer> partial,int remain,int start){
        if(remain<0)
            return;
        else if(remain==0){
            result.add(new ArrayList<>(partial));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(i>start && candidates[i]==candidates[i-1])
                continue;
            partial.add(candidates[i]);
            combinationSum(candidates,partial,remain-candidates[i],i+1);
            partial.remove(partial.size()-1);
        }
    }
}
