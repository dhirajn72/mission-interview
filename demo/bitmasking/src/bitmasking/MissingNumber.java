package bitmasking;
import java.util.Set;
import java.util.HashSet;
class MissingNumber {
    public int missingNumber(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int val:nums){
            set.add(val);
        }
        for(int i=0;i<=nums.length;i++){
            if(!set.contains(i))
                return i;
        }
        return -1;
    }

/*    public int missingNumber(int[] nums) {
        int[] dp=new int[nums.length+1];
        for(int i=0;i<=nums.length;i++){
            dp[i]=Integer.MAX_VALUE;
        }
        for(int i=0;i<nums.length;i++){
            int val=nums[i];
            dp[val]=val;
        }
        for(int i=0;i<=dp.length;i++){
            if(dp[i]==Integer.MAX_VALUE)
                return i;
        }
        return -1;

    }*/
}
