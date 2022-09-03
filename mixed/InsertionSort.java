import java.util.*;
public class InsertionSort{
    static void sort(int[] arr){
        int min=0;
        int j=0;
        for(int  i=1;i<arr.length;i++){
            min=arr[i];
            j=i-1;
            while(j>=0 && min<arr[j]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=min;
        }
    }
    public static void main(String[] args){
        int[] arr={9,8,7,2,6,0,1,2,4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
