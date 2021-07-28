class NumArray {
    int[] nums=null;
    public NumArray(int[] nums) {
        this.nums=nums;
    }
    
    public int sumRange(int i, int j) {
        int result=0;
        if(i<0 || j>nums.length)
            return 0;
        if(i>j)
            return result;
        
        for(int k=i;k<=j;k++){
            result+=nums[k];
        }
        return result;
    }
}
