class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr==null || arr.length==0)
            return false;
        sort(arr,0,arr.length-1);
        for(int i=2;i<arr.length;i++){
            if(arr[i-1]-arr[i-2] !=  arr[i]-arr[i-1] )
                return false;
        }
        return true;
        
    }
    void sort(int[] arr,int low,int high){
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
