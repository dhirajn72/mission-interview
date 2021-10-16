class Solution {
   /*
   public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        int n=nums.length;
        int[] dp=new int[n+1];
        dp[0]=nums[0];
        for(int i=1;i<n;i++){
            if(dp[i-1]>0){
                dp[i]=dp[i-1]+nums[i];
            }
            else{
                dp[i]=nums[i];
            }
        }
        int max=Integer.MIN_VALUE;
        for(int e:dp){
            max=Math.max(max,e);
        }
        return max;
    }
    */

    int max=Integer.MIN_VALUE;
    public int maxSubArray(int[] nums) {
        if(nums==null||nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        backtrack(nums,new ArrayList<>(),0);
        return max;
    }
    void backtrack(int[] nums,List<Integer> list,int start){
        int sum=0;
        for(int e:list){
            sum+=e;
        }
        if(sum>max){
            max=sum;
        }
        for(int i=start;i<nums.length;i++){
            list.add(nums[i]);
            backtrack(nums,list,i+1);
            list.remove(list.size()-1);
        }
    }
}

