class Solution {
    public List<Boolean> result=kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result=new ArrayList<>();
        if(candies==null||candies.length==0)
            return result;
        int max=0;
        for(int e:candies){
            max=Math.max(max,e);
        }
        for(int i=0;i<candies.length;i++){
            if(candies[i]+extraCandies>=max){
                result.add(true);
            }
            else{
                result.add(false);
            }
        }
        return result;
    }
}
