class Solution {
    public int balancedStringSplit(String s) {
        if(s==null||s.length()==0)
            return 0;
        int count=0;
        int result=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='L'){
                count++;
            }
            else{
                count--;
            }
            if(count==0)
                result++;
        }
        return result;
    }
}
