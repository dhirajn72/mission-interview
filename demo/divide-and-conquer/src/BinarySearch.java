public class BinarySearch {
	static int search(int[] nums, int low, int high, int key){
		if(low <= high){
			int mid = (low + high) / 2;
			if( nums[mid] == key)
				return mid;
			if(key < nums[mid])
				return search(nums, low, mid - 1, key);
			else
				return search(nums, mid + 1, high, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7,8};
		System.out.println(search(nums, 0, nums.length - 1, 10)); // -1
		System.out.println(search(nums, 0, nums.length - 1, 1)); // 0
		System.out.println(search(nums, 0, nums.length - 1, 7)); // 6
		System.out.println(search(nums, 0, nums.length - 1, 4)); // 3
		System.out.println(search(nums, 0, nums.length - 1, 2)); // 1
	}
}
