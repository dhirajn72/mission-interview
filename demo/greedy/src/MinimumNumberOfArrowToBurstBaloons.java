import java.util.Arrays;

public class MinimumNumberOfArrowToBurstBaloons{
    class Solution {
        public int findMinArrowShots(int[][] points) {
            Arrays.sort(points,(a, b)-> a[1]-b[1]);
            int arrow=0,count=0;
            long last=Long.MIN_VALUE;
            for(int i=0;i<points.length;i++){
                if(last < points[i][0]){
                    last = points[i][1];
                    count++;
                }
            }
            return arrow;
        }
    }
}
