class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int n=mat.length-1;
        int m=mat[0].length-1;
        int index=0;

        int i=0;
        int j=1;
        List<Integer> list=new ArrayList<>();
        while(i<=n && j<=m ){
            int x=i;
            int y=j;
            while(x<=n && y<=m){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
             x=i;
             y=j;
            while(x<=n && y<=m){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            list.clear();
            j++;
        }
         i=0;
         j=0;
        index=0;
        while(i<=n && j<=m ){
            int x=i;
            int y=j;
            while(x<=n && y<=m){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
             x=i;
             y=j;
            while(x<=n && y<=m){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            list.clear();
            i++;
            j++;
        }


         i=1;
         j=0;
        index=0;
        while(i<=n && j<=m ){
            int x=i;
            int y=j;
            while(x<=n && y<=m){
                list.add(mat[x][y]);
                x++;
                y++;
            }
            Collections.sort(list);
             x=i;
             y=j;
            while(x<=n && y<=m){
                mat[x][y]=list.get(index++);
                x++;
                y++;
            }
            list.clear();
            i++;
        }
    }
}
