class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int result=0;
        int max=values[0]+0;
        for(int i=1;i<values.length;i++){
            max=Math.max(max,values[i-1]+i-1);
            result=Math.max(result,values[i]-i+max);
        }
        return max;
        
    }
}
