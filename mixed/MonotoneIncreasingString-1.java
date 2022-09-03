class Solution {
    public int minFlipsMonoIncr(String s) {
        int result=0;
        int zeros=0;
        int ones=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zeros++;
            }
            else{
                ones++;
            }
            result=Math.min(zeros,ones);
        }
        return result;
    }
}
