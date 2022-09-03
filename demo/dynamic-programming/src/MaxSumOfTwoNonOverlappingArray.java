public class MaxSumOfTwoNonOverlappingArray {
		static public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
			for (int i = 1; i < nums.length; ++i)
				nums[i] += nums[i - 1];

			int res = nums[firstLen + secondLen - 1];
			int Lmax = nums[firstLen - 1];
			int Mmax =nums[secondLen- 1];

			for (int i = firstLen + secondLen; i < nums.length; ++i) {
				Lmax = Math.max(Lmax, nums[i - secondLen] - nums[i - firstLen - secondLen]);
				Mmax = Math.max(Mmax, nums[i - firstLen] - nums[i - firstLen - secondLen]);
				res = Math.max(res, Math.max(Lmax + nums[i] - nums[i - secondLen], Mmax + nums[i] - nums[i - firstLen]));
			}
			return res;
		}

	public static void main(String[] args) {
		int[] nums = {3,8,1,3,2,1,8,9,0};
		int firstLen = 3, secondLen = 2;
		int res = maxSumTwoNoOverlap(nums, firstLen, secondLen);
		System.out.println(res);
	}
}
