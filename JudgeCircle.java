class Solution {
    public boolean judgeCircle(String moves) {
        if(moves==null||moves.length()==0)
            return true;
        int u=0,r=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U')
                u++;
             else if(moves.charAt(i)=='D')
                u--;
             else if(moves.charAt(i)=='L')
                r--;
             else if(moves.charAt(i)=='R')
                r++;
        }
        return u==r;
    }
}
