import java.util.Arrays;
public class SelectionSort{
    private static void sort(int[] nums){
        int min = 0;
        for(int i = 0; i < nums.length; i++){
            min = i;
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] < nums[min])
                    min = j;
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }
    }
    public static void main(String[] args){
        int[] arr={9,8,7,3,4,5,6,1,2,3};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));

    }
}
