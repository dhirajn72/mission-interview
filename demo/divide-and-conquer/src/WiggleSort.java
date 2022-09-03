import java.util.Arrays;

public class WiggleSort {
	class Solution {
		public void wiggleSort(int[] nums) {
			Arrays.sort(nums);
			int[] newnums = new int[nums.length];
			int k = 0;
			int s = (nums.length + 1) / 2 - 1;
			int e = nums.length - 1;

			while(k < nums.length){
				if(k % 2 == 0){
					newnums[k++] = nums[s--];
				}else{
					newnums[k++] = nums[e--];
				}
			}
			for(int i = 0; i < nums.length; i++){
				nums[i] = newnums[i];
			}
		}
	}
}
