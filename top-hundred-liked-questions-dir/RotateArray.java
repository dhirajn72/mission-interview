class Solution {
    public void rotate(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return;
        int n=nums.length;
        k=n%k;
        while(k-->0){
            int temp=nums[n-1];
            for(int i=n-1;i>=1;i--){
                nums[i]=nums[i-1];
            }
            nums[0]=temp;
        }
    }
}
