class Solution {
    public int[][] diagonalSort(int[][] mat) {

        List<Integer> list=new ArrayList<>();
        int i=0,j=1;
        while(j < mat[i].length){
            int x=i;
            int y=j;
            while(x<mat.length  && y < mat[0].length){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x=i;
            y=j;
            int index=0;
            while(x<mat.length  && y < mat[0].length){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            j++;
            list.clear();
        }
        i=0;j=0;
        list.clear();
        while(j<mat[i].length){
            int x=i;
            int y=j;
            while(x<mat.length && y<mat[0].length){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x=i;
            y=j;
            int index=0;
            while(x<mat.length && y < mat[0].length){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            break;
        }
        list.clear();
        i=1;j=0;
        while(i < mat.length){
            int x=i;
            int y=j;
            while(x<mat.length  && y < mat[0].length){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
            x=i;
            y=j;
            int index=0;
            while(x<mat.length  && y < mat[0].length){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            i++;
            list.clear();
        }
       return mat; 
    }
}
