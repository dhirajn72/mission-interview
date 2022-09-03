import java.util.Arrays;
public class SelectionSort{
    public static void sort(int[] arr){
        int min=0;
        for(int i=0;i<arr.length;i++){
            min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            int temp=arr[min];
            arr[min]=arr[i];
            arr[i]=temp;
        }
    }
    public static void main(String[] args){
        int[] arr={9,8,7,2,6,0,1,2,4};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
