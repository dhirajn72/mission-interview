import java.util.Arrays;
public class QuickSort{
    public static void sort(int[] arr,int low,int high){
        int i=low;
        int j=high;
        int pivot=arr[(low+high)/2];

        while(i<=j){
            while(arr[i]<arr[j])
                i++;
            while(arr[j]>arr[i])
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
            sort(arr,low,j);
        if(i<high)
            sort(arr,i,high);
    }

    public static void main(String[] args){
        int[] arr ={3,4,5,6,1,2,0,9,8,7};
        System.out.println(Arrays.toString(arr));
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
}
