class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtrack(n,new ArrayList<>(),k,1);
        return result;
    }
    void backtrack(int n,List<Integer> list,int k,int start){
        if(list.size()==k){
            if(list.get(list.size()-1)>=k)
                result.add(new ArrayList<>(list));
        }
        else{
            for(int i=start;i<=n;i++){
                list.add(i);
                backtrack(n,list,k,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}
