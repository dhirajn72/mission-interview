class Solution {
    public int largestRectangleArea(int[] heights) {
        if(heights==null||heights.length==0)
            return 0;

        Set<Integer> set=new HashSet<>();
        for(int i:heights)
            set.add(i);
        if(set.size()==1)
            return heights[0]*heights.length;

        int n=heights.length;
        int max=0;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=i;j<n;j++){
                if(heights[j]>=heights[i])
                    count++;
                else
                    break;
            }
            for(int j=i-1;j>=0;j--){
                if(heights[j]>=heights[i])
                    count++;
                else
                    break;
            }
            max=Math.max(max,count*heights[i]);
        }
        return max;
    }
}
