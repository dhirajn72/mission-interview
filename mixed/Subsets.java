class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
       if(nums==null||nums.length==0)
           return result;
        
        List<Integer> numsList=new ArrayList();
        for(int i:nums){
            numsList.add(i);
        }
        subsets(numsList,new ArrayList<>());
        return result;
    }

    void subsets(List<Integer> numsList,List<Integer> partial){
        result.add(new ArrayList<>(partial));
        for(int i=0;i<numsList.size();i++){
            List<Integer> remaining=new ArrayList<>();
            int n =numsList.get(i);
            for(int j=i+1;j<numsList.size();j++){
                remaining.add(numsList.get(j));
            }
            List<Integer> partial_res=new ArrayList(partial);
            partial_res.add(n);
            subsets(remaining,partial_res);
        }
    }
}
