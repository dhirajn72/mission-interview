public class Solution{
    List<String> list=new ArrayList<>(); 
    public List<List<String>> solveNQueens(int n){
        int[][] chess=new int[n][n];
        placeQueens(chess,"",0);
        return null;
    }
    void placeQueens(int[][] chess,String qsf,int row){
        if(row==chess.length){
            System.out.println(qsf);
            return;
        }
        else{
            for(int col=0;col<chess[row].length;col++){
                if(isItSafeForQueen(chess,row,col)){
                    chess[row][col]=1;
                    placeQueens(chess,qsf+row+"-"+col,row+1);
                    chess[row][col]=0;
                }
            }
        }
    }

    boolean isItSafeForQueen(int[][] chess,int row,int col){

        for(int i=row-1,j=col;i>=0;i--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(chess[i][j]=1){
                return false;
            }
        }

        for(int i=row,j=col-1;j>=0;j--){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
