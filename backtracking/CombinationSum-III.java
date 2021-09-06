class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k,new ArrayList<>(),n,1);
        return result;
    }
    void backtrack(int k,List<Integer> list,int target,int start){
        if(list.size()==k){
            int sum=0;
            for(int e:list){
                sum+=e;
            }
            if(sum==target){
                result.add(new ArrayList<>(list));
                return;
            }
            if(target>sum){
                return;
            }
        }
        for(int i=start;i<=9;i++){
            list.add(i);
            backtrack(k,list,target,i+1);
            list.remove(list.size()-1);
        }
    }
}
