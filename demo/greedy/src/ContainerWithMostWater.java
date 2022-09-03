public class ContainerWithMostWater {
	class Solution {
		public int maxArea(int[] height) {
			int i=0,j=height.length-1;
			int max=0;
			while(i < j){
				if(height[i] < height[j]) {
					max = Math.max(max,height[i] * (j - i));
					i++;
				}
				else{
					j--;
				}
			}
			return max;
		}
	}
}
