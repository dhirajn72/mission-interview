import java.util.concurrent.*;
import java.util.*;
public class Permutation_2{
    static int permuteCount=0;
    static void  permute(int[] arr,int i){
        if(arr.length==i){
          //  System.out.println(Arrays.toString(arr));
            permuteCount++;
        }
        else{
            for(int j=i;j<arr.length;j++){
                swap(arr,i,j);
                permute(arr,i+1);
                swap(arr,i,j);
            }
        }
    }
    static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    public static void main(String[] args){
        int[] arr={1,2,3,4,5,6,7,8,9,10,11};
			
	//	ExecutorService service= new ForkJoinPool(20);
    //    for(int i=0;i<20;i++){
	//    	service.submit(()->{
                permute(arr,0);
    //        });
    //    }

    //	service.shutdown();
        System.out.println("Total permutation will be: "+permuteCount);

    }
}
