class Solution {
    public int countNegatives(int[][] grid) {
        if(grid==null||grid.length==0)
            return 0;
        int count=0;
        for(int[] arr:grid){
            for(int i:arr){
                if(i<0)
                    count++;
            }
        }
        return count;
    }
}
