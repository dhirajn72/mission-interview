public class BinarySubarrayWithSum {
    /*static public int numSubarraysWithSum(int[] nums, int goal) {
        int start = 0, result = 0, curr = 0;
        for(int end = 0; end < nums.length; end++){
            curr += nums[end];
            if(curr == goal) result++;
            while(curr >= goal){
                curr -= nums[start];
                if(curr == goal) result++;
                start++;
            }
        }
        return result;
    }*/
    /*static public int numSubarraysWithSum(int[] nums, int goal) {
        int result = 0;
        int start = 0, end = 0, sum = 0;
        while(end < nums.length){
            sum += nums[end];
            if(sum == goal)result++;
            while(sum > goal){
                sum -= nums[start];
                start++;
                if(sum == goal)result++;
            }
            end++;
        }
        return result;
    }
     */
    public static  int numSubarraysWithSum(int[] nums, int s){
        int psum = 0, res = 0, count[] = new int[nums.length + 1];
        count[0] = 1;
        for(int i : nums){
            psum += i;
            if(psum >= s){
                res += count[psum - s];
            }
            count[psum]++;
        }
        return res;
    }
    public static void main(String[] args){
        int[] nums = {1, 0, 1, 0, 1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }
}
