import java.util.*;
public class Permutation_3{

    public static void permutation(int[] nums,int i){
        if(i==nums.length)
            System.out.println(Arrays.toString(nums));
        else{
            for(int j=i;j<nums.length;j++){
                swap(nums,i,j);
                permutation(nums,i+1);
                swap(nums,i,j);
            }
        }
    }
    static void swap(int[] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public static void permutation(String str,int i){
        if(i==str.length())
            System.out.println(str);
        else{
            for(int j=i;j<str.length();j++){
                str=swap(str,i,j);
                permutation(str,i+1);
                str=swap(str,i,j);
            }
        }
    }
    static String swap(String str,int i , int j){
        char[] arr=str.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return new String(arr);
    }
    public static void main(String[] args){
        int[] nums={1,2,3};
        permutation(nums,0);
        System.out.println("*********");
        permutation("abc",0);

    }
}
