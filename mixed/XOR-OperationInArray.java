class Solution {
    public int xorOperation(int n, int start) {
        if(n==1)
            return start+2*0;
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=start+2*i;
        }
        int result=nums[0]^nums[1];
        for(int i=2;i<nums.length;i++){
            result = result ^ nums[i];
        }
        return result;      
        
    }
}
