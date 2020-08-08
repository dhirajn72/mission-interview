import java.util.*;

public class MergeSort{
    public static void main(String[] args) {
        int[] arr={5,1,3,6,4,2,7,9,8};
        System.out.println(1/2);
        System.out.println("test" instanceof String);
        System.out.println(Arrays.toString(arr));
        //mergeSort(arr,0,arr.length-1);
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr,int low,int high){
        int i=low,j=high;
        int pivot= arr[(low+high)/2];

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
            quickSort(arr,low,j);
        }
        if(i<high){
            quickSort(arr,i,high);
        }
    }



    static void mergeSort(int[] arr, int low,int high){
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

        int[] leftArr=new int[n1];
        int[] rightArr=new int[n2];

        for(int i=0;i<n1;i++){
            leftArr[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            rightArr[j]=arr[mid+j+1];
        }

        int i=0,j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(leftArr[i]<rightArr[j]){
                arr[k]=leftArr[i];
                i++;
            }
            else{
                arr[k]=rightArr[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=leftArr[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=rightArr[j];
            j++;
            k++;
        }
    }


}