import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSum_III {
	private static Set<List<Integer>> result = new HashSet<>();
	private static void combinationSum(int[] nums, int target){
		if(nums == null || nums.length == 0) return ;
		List<Integer> list = new ArrayList<>();
		Arrays.stream(nums).forEach(e -> list.add(e));
		backtrack(list, 0, 0, target, new ArrayList<>());
	}
	private static void backtrack(List<Integer> list, int start, int sum, int target, List<Integer> partial){
		if(sum == target){
			result.add(new ArrayList<>(partial));
			return;
		}
		if(sum > target) return;
		for(int i = start; i < list.size(); i++){
			ArrayList<Integer> remaining = new ArrayList<>();
			int n = list.get(i);
			for(int j = i 	; j < list.size(); j++){
				remaining.add(list.get(j));
			}
			ArrayList<Integer> partial_res = new ArrayList<>(partial);
			partial_res.add(n);
			backtrack(remaining, i, sum + n, target, partial_res);
		}
	}
	public static void main(String[] args){
		int[] nums = {2,3,6,7 };
		int target = 7;
		combinationSum(nums, target);
		System.out.println(result);
	}
}
