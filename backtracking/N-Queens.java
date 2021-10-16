class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] chess=new char[n][n];
        for(char[] row:chess){
             Arrays.fill(row,'.');
        }
        backtrack(chess,0);
        return result;
    }

    void backtrack(char[][] chess,int start){
        if(start==chess.length){
            List<String> ans=getAns(chess);
            result.add(ans);
            return;
        }
        else{
            for(int i=0;i<chess.length;i++){
                if(isValid(chess,start,i)){
                    chess[start][i]='Q';
                    backtrack(chess,start+1);
                    chess[start][i]='.';
                }
            }
        }
    }
    boolean isValid(char[][] chess,int row,int col){
        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
       for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    List<String> getAns(char[][] chess){
        List<String> res=new ArrayList<>();
        for(char[] row:chess){
            StringBuilder sb=new StringBuilder();
            for(char c:row){
                sb.append(c);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
