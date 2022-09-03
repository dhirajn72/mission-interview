class Solution {
    public int minFlipsMonoIncr(String s) {
        int ones=0;
        int zeros=0;
        if(s==null || s.isEmpty())
            return 0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='0'){
                if(ones==0)
                    continue;
                zeros++;
            }
            else{
                ones++;
            }
            zeros=Math.min(zeros,ones);
        }
        return Math.min(zeros,ones);
    }
}
