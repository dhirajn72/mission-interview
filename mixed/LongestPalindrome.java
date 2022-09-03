class Solution {
    public int longestPalindrome(String s) {
        int len=0;
        Set<Character> set=new HashSet<>();
        for(char c:s.toCharArray()){
            if(set.contains(c)){
                len+=2;
                set.remove(c);
            }
            else{
                set.add(c);
            }
        }
        return set.size()==0 ? len : len+1;
        
    }
}
