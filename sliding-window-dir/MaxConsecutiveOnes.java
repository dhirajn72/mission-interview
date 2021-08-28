class Solution {
    public int longestOnes(int[] nums, int m) {
        if(nums==null||nums.length==0)
            return 0;

        int n=nums.length;
        int result=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j-1;
                int zeros=0,count=0;
                for(int l=j;l<=k;l++){
                    if(zeros==m && nums[l]==0)
                        break;
                    if(nums[l]==1){
                        count++;
                    }
                    else{
                        count++;
                        zeros++;
                    }
                }
                result=Math.max(result,count);
            }
        }
        return result;
        
    }
}
