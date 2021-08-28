class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int[] rows:matrix){
            boolean found=binarySearch(rows,target);
            if(found)
                return true;
        }
        return false;
    }
    boolean binarySearch(int[] rows,int key){
        if(rows==null||rows.length==0)
            return false;
        int low=0;
        int high=rows.length-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(rows[mid]==key)
                return true;
            else if(key<rows[mid]){
                high=mid-1;
            }
            else
                low=mid+1;
        }
        return false;
    }
}
