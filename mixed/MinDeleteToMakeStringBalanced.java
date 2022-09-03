class Solution {
    public int minimumDeletions(String s) {
        int res=0;
        int bcount=0;
        for(char c:s.toCharArray()){
            if(c=='a')
                res=Math.min(++res,bcount);
            else{
                bcount++;
            }
        }
        return res;
        
    }
}
