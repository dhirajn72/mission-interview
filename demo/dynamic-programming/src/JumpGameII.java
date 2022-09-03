public class JumpGameII {
	static public int jump(int[] nums) {
		if(nums == null || nums.length == 0 || nums.length == 1 ) return 0;
		int n = nums.length, max = nums[0], curr = 0, jumps = 0;
		for(int i = 0; i < n - 1; i++) {
			curr = Math.max(curr, i + nums[i]);
			if (i == max) {
				max = curr;
				jumps++;
			}
		}
		return ++jumps;
	}

	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(jump(nums));
	}
}
