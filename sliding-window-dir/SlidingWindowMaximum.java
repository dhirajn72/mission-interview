class Solution {
    public int[] maxSlidingWindow(int[] nums, int K) {
        if(nums==null||nums.length==0)
            return new int[]{};
        int n=nums.length;
        int index=0;
        List<Integer> list=new ArrayList<>();
        int[] result=new int[nums.length-K+1];
        for(int i=0;i<n-K+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<K;j++){
                int num=nums[i+j];
                max=Math.max(max,num);
            }
            result[index++]=max;
        }
        return result;
    }
}

