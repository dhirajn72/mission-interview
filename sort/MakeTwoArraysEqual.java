class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target==null && arr==null)
            return true;
        if(target==null || arr==null)
            return false;
        if(target.length!=arr.length)
            return false;
        sort(target,0,target.length-1);
        sort(arr,0,arr.length-1);
        int i=0,j=0;
        while(i<target.length && j<arr.length){
                if(target[i]!=arr[i])
                    return false;
            i++;
            j++;
        }
        return true;
        
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
