import java.util.*;
public class IncrementArrayByOne{
    static int[] incrementByOne(int[] nums){
        if(nums==null||nums.length==0)
            return  nums;

        if(nums.length==1){
            nums[0]++;
            return nums;
        }
        boolean flag=false;
        int n=nums.length;
        for(int i=n-1;i>=0;i--){
            if(nums[i]==9){
                nums[i]=0;
                flag=true;
                continue;
            }
            if(nums[i]!=9){
                nums[i]++;
                flag=false;
                break;
            }
            else
                flag=false;
        }
        int[] result=new int[n+1];
        if(flag){
            result[0]=1;
            return result;
        }
        return nums;
    }
    public static void main(String[] args){
        System.out.println(Arrays.toString(incrementByOne(new int[]{1})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{123})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{9,9,9})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{2,9,9})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{4,8,9})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{1,1,1,5})));
        System.out.println(Arrays.toString(incrementByOne(new int[]{0,0,0,0,})));

    }
}
