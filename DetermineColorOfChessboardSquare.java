class Solution {
    public boolean squareIsWhite(String coordinates) {
        
        int[][] chessboard=new int[8][8];
        boolean flag=true;
        for(int i=0;i<8;i+=2){
            flag=true;
            for(int j=0;j<8;j++){
                if(flag){
                    chessboard[i][j]=0;
                    flag=false;
                }
                else{
                    chessboard[i][j]=1;
                    flag=true;
                }
            }
        }
        for(int i=1;i<8;i+=2){
            flag=false;
            for(int j=0;j<8;j++){
                if(flag){
                    chessboard[i][j]=0;
                    flag=false;
                }
                else{
                    chessboard[i][j]=1;
                    flag=true;
                }
            }
        }
        Map<Character,Integer> map=new HashMap<>();
        map.put('a',0);
        map.put('b',1);
        map.put('c',2);
        map.put('d',3);
        map.put('e',4);
        map.put('f',5);
        map.put('g',6);
        map.put('h',7);

        Map<Integer,Integer> map1=new HashMap<>();
        map1.put(8,0);
        map1.put(7,1);
        map1.put(6,2);
        map1.put(5,3);
        map1.put(4,4);
        map1.put(3,5);
        map1.put(2,6);
        map1.put(1,7);
        int n=Integer.valueOf(coordinates.charAt(1)+"");
        int m=map.get(coordinates.charAt(0));
        return chessboard[map1.get(n)][m]==0;
    }
}
