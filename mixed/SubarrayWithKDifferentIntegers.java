class Solution {
    int result=0;
    public int subarraysWithKDistinct(int[] nums, int k) {
        if(nums==null||nums.length==0)
            return result;
        int n=nums.length;
        for(int i=k;i<=n;i++){
            Set<Integer> set=new HashSet<>();
            for(int j=0;j<=n-i;j++){
                int l=i+j-1;
                for(int m=j;m<=l;m++){
                    set.add(nums[m]);
                }
                if(set.size()==k){
                    result++;
                    set.clear();
                }
            }
        }
        return result;
    }
}
