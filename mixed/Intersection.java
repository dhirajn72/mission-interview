class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         if(nums1==null)
            return nums2;
        if(nums2==null)
            return nums1;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0;
        int j=0;
        Set<Integer> set=new HashSet<>();
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                set.add(nums1[i]);
                i++;
                j++;
            }
            else if(nums1[i]>nums2[j])
                j++;
            else
                i++;
        }
        int[] result=new int[set.size()];
        int index=0;
        for(int e:set)
            result[index++]=e;
        return result;
    }
}


