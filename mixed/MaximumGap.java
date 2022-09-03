class Solution {
    public int maximumGap(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        mergeSort(nums,0,nums.length-1);
        int max=Integer.MIN_VALUE;
        for(int i=1;i<nums.length;i++){
            max=Math.max(max,nums[i]-nums[i-1]);
        }
        return max;
    }
    void mergeSort(int[] arr, int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            sort(arr,low,mid,high);
        }
    }
    void sort(int[] arr,int low,int mid,int high){
        int n1=mid-low+1;
        int n2=high-mid;

        int[] leftArray=new int[n1];
        int[] rightArray=new int[n2];

        for(int i=0;i<n1;i++)
            leftArray[i]=arr[low+i];
        for(int j=0;j<n2;j++)
            rightArray[j]=arr[mid+1+j];

        int i=0,j=0;
        int k=low;
        while(i<n1 && j<n2){
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

        while(i<n1){
            arr[k]=leftArray[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=rightArray[j];
            j++;
            k++;
        }
    }
}
