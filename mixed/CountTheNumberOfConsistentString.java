class Solution {
    public int countConsistentStrings(String allowed, String[] words) {

        Set<Character> set=new HashSet<>();
        for(char c:allowed.toCharArray()){
            set.add(c);
        }
        int res=0;
        for(String str:words){
            boolean flag=true;
            for(char c:str.toCharArray()){
                if(!set.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag)
                res++;
        }
       return res;
    }
}
