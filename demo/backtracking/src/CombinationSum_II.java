import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum_II {
	private static Set<List<Integer>> result = new HashSet<>();
	private static void combinationSum(int[] nums, int target){
		if(nums == null || nums.length == 0) return ;
		backtrack(nums, 0, 0, target, new ArrayList<>());
	}
	private static void backtrack(int[] nums, int start, int sum, int target, List<Integer> list){
		if(start == nums.length) return;
		if(sum == target){
			result.add(new ArrayList<>(list));
			return;
		}
		else{
			for(int i = start; i < nums.length; i++){
				list.add(nums[i]);
				backtrack(nums, start + 1, sum + nums[i], target, list);
				list.remove(list.size() - 1);
			}
		}
	}
	public static void main(String[] args){
		int[] nums = {2,3,6,7 };
		int target = 7;
		combinationSum(nums, target);
		System.out.println(result);
	}
}
