class Solution {
    public int minOperations(String s) {
        int first=0;
        int second=0;
        
        char ones='1';
        char zeros='0';
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!=ones){
                first++;
            }
            if(s.charAt(i)!=zeros){
                second++;
            }
            ones  = ones =='1' ? '0'  : '1';
            zeros = zeros=='1' ? '0' : '1';
        }
        return Math.min(first,second);
    }
}
