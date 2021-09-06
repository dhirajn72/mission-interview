class Solution {
    List<List<Integer>> result=new ArrayList<>();
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum=0;
        for(int e:nums){
            sum+=e;
        }
        if(sum%k!=0)
            return false;

        Arrays.sort(nums);
        int target=sum/k;
        backtrack(nums,new ArrayList<>(),k,0,target);
        System.out.println(result);
        return result.size()==k;
    }
    List<Integer> indexes=new ArrayList<>();
    void backtrack(int[] nums,List<Integer> list,int k,int start,int target){
        int sum=0;
        for(int e:list){
            sum+=e;
        }
        if(sum==target){
            if(result.size()!=k){
                result.add(new ArrayList<>(list));
            }
        }
        else{
            for(int i=start;i<nums.length;i++){
                list.add(nums[i]);  
                backtrack(nums,list,k,i+1,target);
                list.remove(list.size()-1);
            }
        }
    }
}

/*
[1,2,2,2,2]
3
[2,2,2,2,3,4,5]
4
[2,2,2,2,3,4,5]
4
[1,1,1,1,2,2,2,2]
4
[1,1,1,1,2,2,2,2]
2
[1,1,1,1,2,2,2,2]
4

*/
