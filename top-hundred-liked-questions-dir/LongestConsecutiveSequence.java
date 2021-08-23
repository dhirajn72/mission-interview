
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int e:nums)
            set.add(e);
        int result=0;
        for(int e:nums){
            if(!set.contains(e-1)){
                int c=e-1;
                int count=0;
                while(set.contains(c+1)){
                    c++;
                    count++;
                }
                result=Math.max(result,count);
            }
        }
        return result;
    }
}
