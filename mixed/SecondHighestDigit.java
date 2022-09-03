class Solution {
    public int secondHighest(String s) {
        int result=0;
        if(s==null||s.length()==0)
            return result;
        Set<Integer> set=new TreeSet<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)>=48 && s.charAt(i)<=57){
                set.add(Integer.valueOf(s.charAt(i)+""));
            }
        }
        if(set.size()==1|| set.size()==0)
            return -1;
        return new ArrayList<>(set).get(set.size()-2);
    }
}
