import java.util.*;
public class Permutations{
    static void permutation(int[] nums,int i){
        if(nums.length==i){
            System.out.println(Arrays.toString(nums));
        }
        else{
            for(int j=i;j<nums.length;j++){
                swap(nums,i,j);
                permutation(nums,i+1);
                swap(nums,i,j);
            }
        }
    }
    static void swap(int[] nums,int i, int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }

    public static void main(String[] args){
        int[] arr={1,2,3};
        permutation(arr,0);
    }
}
