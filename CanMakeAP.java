class Solution {
    public boolean canMakeArithmeticProgression(int[] arr) {
        if(arr==null)
            return false;
        Map<Integer,Integer> map=new HashMap<>();
        quickSort(arr,0,arr.length-1);
        for(int i=2;i<arr.length;i++){
            if(!(arr[i]-arr[i-1] == arr[i-1]-arr[i-2]))
                return false;
        }
        return true;
    }
    void quickSort(int[] arr,int low,int high){
        int i=low;
        int j=high;
        int pivot=arr[(low+high)/2];
        while(i<=j){
            while(arr[i]<pivot)
                i++;
            while(arr[j]>pivot)
                j--;
            if(i<=j){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }

        if(low<j)
            quickSort(arr,low,j);
        if(i<high)
            quickSort(arr,i,high);
    }
}
