class Solution {
    public boolean exist(char[][] board, String word) {

        int n=board.length;
        int m=board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]==word.charAt(0) && findWord(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return false;
    }
    boolean findWord(char[][] board, int i,int j,int count, String word){
        if(count==word.length())
            return true;

        if(i<0 || i>=board.length || j<0 || j>=board[i].length || board[i][j]!=word.charAt(count))
            return false;

            char temp=board[i][j];
            board[i][j]=' ';
            boolean found= findWord(board,i+1,j,count+1,word)
                        || findWord(board,i-1,j,count+1,word)
                        || findWord(board,i,j+1,count+1,word)
                        || findWord(board,i,j-1,count+1,word);
            board[i][j]=temp;
            return found;
    }
}
