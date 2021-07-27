class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers=new ArrayList<>();
        HashSet<Integer> numbers=new HashSet<>();
        for(int i:nums){
             numbers.add(i);
        }
        for(int i=0;i<nums.length;i++){
            if(!numbers.contains(i)){
                missingNumbers.add(i);
            }
        }
        return missingNumbers;
    }
}







