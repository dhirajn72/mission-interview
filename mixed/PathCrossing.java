class Solution {
    public boolean isPathCrossing(String path) {
        int x=0;
        int y=0;
        for(char c:path.toCharArray()){
            if(c=='N'){
                y++;
            }
            else if(c=='S'){
                y--;
            }
            else if(c=='E'){
                x++;
            }
            else if(c=='w'){
                x--;
            }
            if(x==0 && y==0)
                return true;
        }
        return false;
        
    }
}
