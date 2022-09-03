public class MinimizeMaximumPairSum {
	class Solution {
		public int minPairSum(int[] nums) {
			quickSort(nums,0,nums.length);
			int res=Integer.MIN_VALUE;
			int i=0,j=nums.length-1;

			for(int e:nums){
				res=Math.max(res,nums[i++]+nums[j--]);
			}
			return res;

		}
		void quickSort(int[] nums,int low,int high){
			int i=low,j=high;
			int pivot=nums[(low+high)/2];
			while(i<=j){
				while(nums[i]<pivot){
					i++;
				}
				while(nums[j]>pivot){
					j--;
				}
				if(i<=j){
					int temp=nums[i];
					nums[i]=nums[j];
					nums[j]=temp;
					i++;
					j--;
				}
			}
			if(low<j)
				quickSort(nums,low,j);
			if(i<high)
				quickSort(nums,i,high);
		}
	}
}
