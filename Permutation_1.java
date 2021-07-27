import java.util.*;
public class Permutation_1{
    public static void main(String[] args){
        int[] arr= {1,2,3};
        permute(arr,0);
    }
    
    static void permute(int[] arr, int i){
        if(arr.length==i){
            System.out.println(Arrays.toString(arr));
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(i,j,arr);
                permute(arr,i+1);
                swap(i,j,arr);
            }
        }

    }

    static void swap(int i,int j,int[] arr){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
