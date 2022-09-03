class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] result=new int[nums.length];
        int index=0;
        int i=0;
        while(i<nums.length){
            int j= i==0 ? 1:0;
            int count=0;
            while(j<nums.length ){
                if( i!=j && nums[j]<nums[i]){
                    count++;
                }
                j++;
            }
            result[index++]=count;
            i++;
        }
        return result;
    }
}
