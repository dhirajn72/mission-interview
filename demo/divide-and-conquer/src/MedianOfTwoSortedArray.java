public class MedianOfTwoSortedArray {
	class Solution {
		public double findMedianSortedArrays(int[] nums1, int[] nums2) {
			int[] nums=new int[nums1.length+nums2.length];
			int index=0;
			for(int e:nums1){
				nums[index++]=e;
			}
			for(int e:nums2){
				nums[index++]=e;
			}
			quickSort(nums,0,nums.length-1);
			index=nums.length/2;
			if(index%2==0){
				return (nums[index]+nums[index-1])/2.0;
			}
			else {
				return nums[index - 1];
			}
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
			if(low<j){
				quickSort(nums,low,j);
			}
			if(i<high){
				quickSort(nums,i,high);
			}
		}
	}
}
