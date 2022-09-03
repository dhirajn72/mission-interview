class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        if(arr==null)
            return false;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.compute(i,(k,v)->v==null?1:v+1);
        }
        Set<Integer> set=new HashSet<>();
        for(int i:map.values()){
            if(set.contains(i))
                return false;
            set.add(i);
        }
        return true;
    }
}
