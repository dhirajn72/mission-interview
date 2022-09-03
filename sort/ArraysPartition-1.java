class Solution {
    public int arrayPairSum(int[] nums) {
        if(nums==null)
            return 0;
        sort(nums,0,nums.length-1);
        int result=0;
        int n=nums.length;
        for(int i=0;i<n-1;i+=2){
            result+=Math.min(nums[i],nums[i+1]);
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
