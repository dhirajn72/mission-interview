class Solution {
    Set<List<Integer>> result=new HashSet<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list=new ArrayList<>();
        permuteUnique(nums,0);
        return new ArrayList<>(result);
        
    }

    void permuteUnique(int[] nums,int i){
        if(nums.length==i){
            List<Integer> partial=new ArrayList<>();
            for(int e:nums)
                partial.add(e);
            result.add(partial);
        }
        else{
            for(int j=i;j<nums.length;j++){
                swap(nums,i,j);
                permuteUnique(nums,i+1);
                swap(nums,i,j);
            }
        }
    }
    void swap(int[] arr,int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
