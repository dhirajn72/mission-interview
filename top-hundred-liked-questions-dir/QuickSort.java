import java.util.Arrays;
public class QuickSort{
    static void sort(int[] arr,int low,int high){
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
            sort(arr,low,i);
        }
        if(i<high){
            sort(arr,i,high);
        }
    }
    public static void main(String[] args){
        int[] arr={9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    
} 
