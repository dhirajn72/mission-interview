class Solution {
    public int[] sortedSquares(int[] A) {
        if(A==null||A.length==0)
            return new int[]{};
        for(int i=0;i<A.length;i++){
            A[i]*=A[i];
        }
        mergeSort(A,0,A.length-1);
        return A;
    }
    void mergeSort(int[] arr,int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }
    void merge(int[] arr,int low,int mid,int high){
        int n1=mid-low+1;
        int n2=high-low;

        int[] leftArray=new int[n1];
        int[] rightArray=new int[n2];
        for(int i=0;i<n1;i++){
            leftArray[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j]=arr[mid+1+j];
        }
        int i=0,j=0;
        int k=low;
        while(i<=n1 && j<=n2){
            if(leftArray[i]<rightArray[j]){
                arr[k]=leftArray[i];
                i++;
            }
            else{
                arr[k]=rightArray[j];
                j++;
            }
            k++;
        }
        while(i<=n1){
            arr[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<=n2){
            arr[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
