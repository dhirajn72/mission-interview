public class MinOperations {
	static public int minOperations(int[] nums, int x) {
		int sum = 0;
		for (int num: nums) sum += num;

		int maxLength = -1, currSum = 0;
		for (int l=0, r=0; r<nums.length; r++) {
			currSum += nums[r];
			while (l <= r && currSum > sum - x)
				currSum -= nums[l++];
			if (currSum == sum - x)
				maxLength = Math.max(maxLength, r-l+1);
		}

		return maxLength == -1 ? -1 : nums.length - maxLength;
	}
	public static void main(String[] args){
		//int x = 3,  arr[] = {};
		int x = 5, arr[] = {1,1,4,2,3};
		//int x = 4, arr[] = {5,6,7,8,9};
		//int x = 10, arr[] = {3,2,20,1,1,3};
		System.out.println(minOperations(arr, x));
	}
}
