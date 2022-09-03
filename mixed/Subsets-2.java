class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list=new ArrayList<>();
       // for(int e:nums)
        //    list.add(e);
        //subsets(list,new ArrayList<>());
        subsets(nums,new ArrayList<>(),0);
        return result;
    }

    /*void subsets(List<Integer> nums,List<Integer> partial){
            result.add(new ArrayList<>(partial));
            for(int i=0;i<nums.size();i++){
                List<Integer> remaining=new ArrayList<>();
                int n=nums.get(i);
                for(int j=i+1;j<nums.size();j++){
                    remaining.add(nums.get(j));
                }
                List<Integer> partial_res=new ArrayList<>(partial);
                partial_res.add(n);
                subsets(remaining,partial_res);
            }
    }*/
    void subsets(int[] nums,List<Integer> res,int start){
        result.add(new ArrayList<>(res));
        for(int i=start;i<nums.length;i++){
            res.add(nums[i]);
            subsets(nums,res,start+1);
            res.remove(res.size()-1);
        }
    }
}
