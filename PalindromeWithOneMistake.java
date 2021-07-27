class Solution {
    public boolean validPalindrome(String s) {
        if(s==null||s.isEmpty())
            return true;
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return isPalindrome(s,start+1,end) || isPalindrome(s,start,end-1);
            }
            start++;
            end--;
        }
        return true;
    }

    boolean isPalindrome(String s,int start, int end){
        while(start<end){
            if(s.charAt(start)!=s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
