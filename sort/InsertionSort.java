import java.util.Arrays;
public class InsertionSort{
    static void sort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            int min=arr[i];
            while(j>=0 && min<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=min;
        }
    }
    public static void main(String[] args){
        int[] arr={9,8,7,3,4,5,6,1,2,3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}

