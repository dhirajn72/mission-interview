public class MinimumOperationToMakeAnArrayStrictlyIncreasing {
		static public int minOperations(int[] nums) {
			int count = 0;
			int n = nums.length;
			if(n==1 || n==0)
				return 0;
			for(int i=0; i<n-1; i++){
				if(nums[i] >= nums[i+1]){
					int temp = nums[i+1];
					nums[i+1] = nums[i] + 1;
					count += nums[i+1] - temp;
				}
			}
			return count;
		}

	public static void main(String[] args) {
		int[] arr={1,1,1};
		System.out.println(minOperations(arr));

	}
}
