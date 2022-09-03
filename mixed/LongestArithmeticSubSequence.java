class Solution {
    public int longestArithSeqLength(int[] nums) {
        if(nums==null || nums.length<2)
            return 0;

        Map<Integer,Integer>[] map = new HashMap[nums.length];
        Arrays.fill(map,new HashMap<>());
        int result=0;
        for(int i=1;i<nums.length;i++){
            for(int j=0;j<i;j++){
                int diff=nums[i]-nums[j];
                int seq=map[j].getOrDefault(diff,1)+1;
                map[i].put(diff,seq);
                result=Math.max(seq,result);
            }
        }
        return result;
    }
}
