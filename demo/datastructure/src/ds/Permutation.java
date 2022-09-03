package ds;

import java.util.Arrays;

public class Permutation {
	public static void main(String[] args) {
		permutation(new int[]{1,2,3}, 0, 3);
	}

	private static void permutation(int[] nums, int start, int len) {
		if(start == len){
			System.out.println(Arrays.toString(nums));
			return;
		}
		for(int  i = start; i < nums.length; i++){
			swap(nums, start, i);
			permutation(nums, start + 1, len);
			swap(nums, start, i);
		}
	}
	static void swap(int[] nums, int i, int j){
		int temp = nums[i] ;
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
