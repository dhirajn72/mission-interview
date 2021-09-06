class Solution {
    Set<String> set=new HashSet<>();
    public int maxUniqueSplit(String s) {
        backtrack(s,new ArrayList<>(),0);
        return set.size();
    }

    void backtrack(String s,List<String> list,int start){
        for(String e:list){
            set.add(e);
        }
        for(int i=start;i<s.length();i++){
            list.add(s.substring(start,i+1));
            backtrack(s,list,i+1);
            list.remove(list.size()-1);
        }
    }
}
