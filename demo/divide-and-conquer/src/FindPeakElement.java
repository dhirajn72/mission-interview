import java.util.ArrayList;
import java.util.List;

public class FindPeakElement {
    class Solution{
        public int[] findPeakGrid(int[][] mat) {
            List<Integer> list=new ArrayList<>();
            for(int i=1;i<mat.length-1;i++){
                for(int j=1;j<mat[i].length-1;j++){
                    if(mat[i][j] > mat[i-1][j] && mat[i][j]>mat[i][j-1] && mat[i][j]>mat[i+1][j] && mat[i][j]>mat[i][j+1])
                        list.add(mat[i][j]);
                }
            }
            int[] result=new  int[list.size()];
            int index=0;
            for(int e:list){
                result[index++]=e;
            }
            return result;

        }
    }
}
