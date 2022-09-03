import java.util.*;
public class MergeSort_3{
    public static  void mergeSort(int[] arr,int low, int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr,low,mid);
            mergeSort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    static void merge(int[] arr,int low,int mid,int high){
        int n1=mid-low+1;
        int n2=high-mid;

        int[] leftArray=new int[n1];
        int[] rightArray=new int[n2];

        for(int i=0;i<n1;i++){
            leftArray[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            rightArray[j]=arr[mid+j+1];
        }
        
        int i=0,j=0,k=low;
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

    public static void main(String[] args) {
        int[] arr={7,3,1,5,8,2,9};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
