class Solution {
    public int missingNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int val:nums){
            map.put(val,val);
        }
        int n=nums.length;
        int i=0;
        while(i<=nums.length){
            if(!map.containsKey(i))
                return i;
        }
        return -1;
    }
}
