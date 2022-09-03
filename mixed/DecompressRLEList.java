class Solution {
    public int[] decompressRLElist(int[] nums) {
        if(nums==null||nums.length==0)
            return new int[]{};
        List<Integer> list=new ArrayList<>();
        boolean flag=true;
        int e=0;
        for(int i=0;i<nums.length;i++){
            if(flag){
                e=nums[i];
                flag=false;
            }
            else{
                for(int j=0;j<e;j++){
                    list.add(nums[i]);
                }
                flag=true;
            }
        }
        int[] result=new int[list.size()];
        int index=0;
        for(int i:list){
            result[index++]=i;
        }
        return result;
    }
}
