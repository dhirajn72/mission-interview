class Solution {
    public int heightChecker(int[] heights) {
        if(heights==null)
            return 0;
        int[] expected=new int[heights.length];
        for(int i=0;i<heights.length;i++){
            expected[i]=heights[i];
        }
        sort(expected,0,expected.length-1);
        int result=0;
        int i=0;
        while(i<expected.length){
            if(expected[i]!=heights[i])
                result++;
            i++;
        }
        return result;
    }
    public static void sort(int[] arr,int low,int high){
        int i=low,j=high;
        int pivot=arr[(low+high)/2];

        while(i<=j){
            while(arr[i]<pivot){
                i++;
            }
            while(arr[j]>pivot){
                j--;
            }
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        if(low<j){
            sort(arr,low,j);
        }
        if(i<high){
            sort(arr,i,high);
        }
    }

}
