import  java.util.Arrays;

public class Permutation {

    static int count=0;
    static void permutation(String s, int i){
        if(i==s.length()){
            System.out.println(s);
        }
        else{
            for(int j=i;j<s.length();j++){
                s=swap(s,i,j);
                permutation(s,i+1);
                s=swap(s,i,j);
            }
        }
    }
    static void permutation(int[] arr, int i){
        if(i==arr.length){
            System.out.println(Arrays.toString(arr));
            count++; 
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(arr,i,j);
                permutation(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    static String swap(String s,int i,int j){
        char[] arr=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return new String(arr);
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        permutation("ABC",0);
        System.out.println("******");
        permutation(new int[]{1,2,3,4,5},0);
        System.out.println(count);
    }
}