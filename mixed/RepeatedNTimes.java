class Solution {
    public int repeatedNTimes(int[] A) {
        if(A==null||A.length==0)
            return 0;
        Set<Integer> set=new HashSet<>();
        for(int i:A){
            if(set.contains(i))
                return i;
            set.add(i);
        }
        return -1;
    }
}
