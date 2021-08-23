class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Set<List<Integer>> result=new HashSet<>();     
        int left=0;
        int right=n-1;
        Arrays.sort(nums);
        for(int i=0;i<n-1;i++){
            int first=nums[i];
            int start=i+1;
            int end=n-1;
            while(start<end){
                int second=nums[start];
                int third=nums[end];
                int sum=first+second+third;
                if(sum==0){
                    List<Integer> list=new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);
                    result.add(list);
                }
                if(sum>0)
                    end--;
                else
                    start++;
            }
        }
        return new ArrayList<>(result);
    }
}   
