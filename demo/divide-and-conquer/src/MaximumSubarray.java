public class MaximumSubarray {
	// Call it : maxSum(nums,0,nums.length-1);
	int maxSum(int[] nums,int low,int high){
		if(low==high)
			return nums[low];

		int leftMax=0,rightMax=0,arrMax=0;
		if(low<high){
			int mid=(low+high)/2;
			leftMax=maxSum(nums,low,mid);
			rightMax=maxSum(nums,mid+1,high);
			arrMax=sum(nums,low,mid,high);
		}
		return Math.max(arrMax,Math.max(leftMax,rightMax));
	}
	int sum(int[] nums,int low,int mid,int high) {
		int leftSum = 0, leftMax = Integer.MIN_VALUE;
		for (int i = mid; i >= 0; i--) {
			leftSum += nums[i];
			leftMax = Math.max(leftMax, leftSum);
		}
		int rightSum = 0, rightMax = Integer.MIN_VALUE;
		for (int i = mid + 1; i <= high; i++) {
			rightSum += nums[i];
			rightMax = Math.max(rightMax, rightSum);
		}
		return leftMax + rightMax;
	}
}
