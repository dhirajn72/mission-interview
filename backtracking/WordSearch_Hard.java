class Solution {
    List<String> result=new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int n=board.length;
        int m=board[0].length;

        for(String word:words){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(board[i][j]==word.charAt(0) && dfs(board,i,j,word,0)){
                        if(!result.contains(word))
                            result.add(word);
                    }
                }
            }
        }
        return result;
    }
    boolean dfs(char[][] board,int i,int j,String  word,int count){
        if(count==word.length())
            return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length|| board[i][j]!=word.charAt(count))
            return false;

        char temp=board[i][j];
        boolean found=dfs(board,i+1,j,word,count+1)
                    || dfs(board,i-1,j,word,count+1)
                    || dfs(board,i,j+1,word,count+1)
                    || dfs(board,i,j-1,word,count+1);

        board[i][j]=temp;
        return found;
                    
    }
}
