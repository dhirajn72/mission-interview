class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=0;
        int end=nums.length-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(nums[mid]==target){
                return searchRange(nums,mid,target);
            }
            if(target<nums[mid]){
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return new int[]{-1,-1};
    }
    int[] searchRange(int[] nums,int mid,int target){
        int start=mid;
        while(start>=0 && nums[start]==target){
            start--;
        }
        int end=mid;
        while( end<nums.length-1 && nums[end]==target)
            end++;
        end=end-1<0 ? 0:end-1;
        return new int[]{start+1,end};
    }

}
