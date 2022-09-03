import java.util.Arrays;

public class MaximumLengthOfPairChain {
	class Solution {
		public int findLongestChain(int[][] pairs) {
			Arrays.sort(pairs,(a,b)-> a[1]-b[1]);
			int max=0;
			int curr_left= pairs[0][1];
			for (int i=1;i<pairs.length;i++) {
				if( curr_left < pairs[i][0] ) {
					max++;
					curr_left = pairs[i][1];
				}
				else {

				}
			}
			return max;
		}
	}
}
