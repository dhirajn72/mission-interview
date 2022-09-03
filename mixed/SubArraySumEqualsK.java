class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            int sum=0;
            int count=0;

            if(nums[i]==k){
                count++;
            }

            sum+=nums[i];
            for(int j=i-1;j>=0;j--){
                sum+=nums[j];
                if(sum==k){
                    count++;
                }
            }
            if(i==0){
                dp[i]=count;
            }
            else{
                dp[i]=dp[i-1]+count;
            }

        }
        return dp[n-1];
    }
}
