import java.util.Arrays;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int pivot = indexOfLastPeak(nums) - 1;
		if (pivot != -1) {
			int next = elementOnPivot(nums, nums[pivot]);
			swap(nums, pivot, next);
		}
		reverseSuffix(nums, pivot + 1);
	}

	void reverseSuffix(int[] nums, int start) {
		int end = nums.length - 1;
		while (start < end) {
			swap(nums, start++, end--);
		}
	}

	void swap(int[] nums, int pivot, int next) {
		int temp = nums[pivot];
		nums[pivot] = nums[next];
		nums[next] = temp;
	}

	int elementOnPivot(int[] nums, int threshold) {
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] > threshold)
				return i;
		}
		return 0;
	}

	int indexOfLastPeak(int[] nums) {
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i - 1] < nums[i])
				return i;
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,4,4,3,3};
		NextPermutation per = new NextPermutation();
		System.out.println(Arrays.toString(nums));
		per.nextPermutation(nums);
		System.out.println(Arrays.toString(nums));

	}
}
