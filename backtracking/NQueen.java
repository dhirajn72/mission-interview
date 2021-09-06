public class Solution{
    List<String> list=new ArrayList<>(); 
    public List<List<String>> solveNQueens(int n){
        int[][] chess=new int[n][n];
        solveNQueens(chess,"",0);
        List<List<String>> result=new ArrayList<>();
        for(String s:list){
            List<String> res=new ArrayList<>();
            String[] arr=s.split(",");
            for(String row:arr){
                char[] ar=new char[n];
                Arrays.fill(ar,'.');
                int index=Integer.valueOf(s.charAt(s.length()-1)+"");
                ar[index]='Q';
                res.add(new String(ar));
                result.add(res);
            }
        }
        System.out.println(list);
        return result;
    }
    void solveNQueens(int[][] chess,String qsf,int row){
        if(row==chess.length){
            qsf=qsf.substring(0,qsf.length()-1);
            System.out.println(qsf);
            list.add(qsf);
            return ;
        }
        else{
            for(int col=0;col<chess[row].length;col++){
                if(isItSafePlaceForQueen(chess,row,col)){
                    chess[row][col]=1;
                    solveNQueens(chess,qsf+row+"-"+col+",",row+1);
                    chess[row][col]=0;
                }
            }
        }
    }

    boolean isItSafePlaceForQueen(int[][] chess,int row,int col){

        for(int i=row-1,j=col;i>=0 ;i-- ){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col-1;i>=0 && j>=0 ; i--,j--){
            if(chess[i][j]==1){
                return false;
            }
        }

        for(int i=row-1,j=col+1;i>=0 && j<chess.length;i--,j++){
            if(chess[i][j]==1){
                return false;
            }
        }
        return true;
    }
}
