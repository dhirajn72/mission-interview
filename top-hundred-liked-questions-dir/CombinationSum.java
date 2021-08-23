class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0)
            return result;
        List<Integer> list=new ArrayList<>();
        for(int e:candidates)
            list.add(e);
        combinationSum(list,new ArrayList<>(), target);
        return result;
    }

    void combinationSum(List<Integer> candidates, List<Integer> partial,int target){
        int sum=0;
        for(int e:partial){
            sum+=e;
            if(sum==target){
                result.add(new ArrayList<>(partial));
                return ;
            }
        }
        if(sum>target){
            return;
        }
        else{
            for(int i=0;i<candidates.size();i++){
                //int[] remaining=new int[candidates.length];
                List<Integer> remaining=new ArrayList<>();
                int n=candidates.get(i);
                for(int j=i;j<candidates.size();j++){
                    remaining.add(candidates.get(j));
                }
                List<Integer> partial_res=new ArrayList<>(partial);
                partial_res.add(n);
                combinationSum(remaining,partial_res,target);
            }
        }
    }
}
