class Solution {
    public int[] maxSlidingWindow(int[] nums, int K) {

        int n=nums.length;
        if(K==1){
            return nums;
        }
        if(n==2){
            return new int[]{Math.max(nums[0],nums[1])};
        }
        if(K==n){
            int max=Integer.MIN_VALUE;
            for(int e:nums)
                max=Math.max(max,e);
            return new int[]{max};           
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n-K+1;i++){
            int max=Integer.MIN_VALUE;
            for(int j=0;j<K;j++){
                int k=nums[i+j];
                max=Math.max(max,k);
            }
            list.add(max);
        }
        int[] resultArr=new int[list.size()];
        int index=0;
        for(int i=0;i<list.size();i++){
            resultArr[index++]=list.get(i);
        }
        return resultArr;
    }
    int findMax(int[] nums,int start,int end){
        int max=Integer.MIN_VALUE;
        for(int i=start;i<=end;i++){
            max=Math.max(max,nums[i]);
        }
        return max;
    }
}
