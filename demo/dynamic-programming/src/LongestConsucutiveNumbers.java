import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

public class LongestConsucutiveNumbers {
	static public int longestConsecutive(int[] nums) {
		Set<Integer> set=new HashSet<>();
		for(int e:nums)
			set.add(e);
		int result=0;
		for(int num : nums){
			if(!set.contains(num - 1)){
				int prev = num - 1;
				int count=0;
				while(set.contains(prev + 1)){
					prev++;
					count++;
				}
				result=Math.max(result,count);
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {100,4,200,1,3,2};
		System.out.println(longestConsecutive(nums));
		Semaphore semaphore = new Semaphore(1);
	}
}
