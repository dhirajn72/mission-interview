import java.util.HashSet;
import java.util.Set;

public class MaximumErasureValue {
    public static void main(String[] args){
        int[] nums = {5,2,1,2,5,2,1,2,5};
        System.out.println(maximumUniqueSubarray(nums));
    }
    static public int maximumUniqueSubarray(int[] nums) {
        int result = 0, sum = 0;
        Set<Integer> set = new HashSet<>();
        for(int low = 0, high = 0; high < nums.length;){
            if(set.add(nums[high])){
                sum += nums[high++];
                result = Math.max(result, sum);
            }
            else{
                sum -= nums[low];
                set.remove(nums[low++]);
            }
        }
        return result;
    }
}
