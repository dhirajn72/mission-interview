import java.util.HashSet;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class PairsSumToTarget {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//String numbers = sc.nextLine();
		//String X = sc.nextLine();

		int[] nums =  {1,2,3,4,5,6,7,8,9,10};//convertToArray(numbers);
		int target =  10; //Integer.valueOf(X);
		Set<Pair> result = new HashSet<>();
		for (int start = 0; start < nums.length; start++) {
			int i = start, j = nums.length - 1;
			while (i < j) {
				int sum = nums[i] + nums[j];
				if (sum == target) {
					System.out.println(nums[i] +":"+nums[j]);
					result.add(new Pair(nums[i], nums[j]));
					i++;
					j--;
				}
				if (sum > target) {
					j--;
				}
				if (sum < target) {
					i++;
				}
			}
		}
		// O(n + √n)
		System.out.println(result);
		PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.val1 - b.val1);
		for(Pair pair : result){
			pq.add(pair);
		}
		System.out.println(pq);
	}
	static class Pair{
		int val1, val2;
		Pair(int val1, int val2){
			this.val1 = val1;
			this.val2 = val2;
		}

		@Override
		public boolean equals(Object o) {
			return this.val1 == ((Pair)o).val1 && this.val2 == ((Pair)o).val2;
		}

		@Override
		public int hashCode() {
			return 1;
		}

		@Override
		public String toString() {
			return "Pair{" +
					"val1=" + val1 +
					", val2=" + val2 +
					'}';
		}
	}

	static int[] convertToArray(String numbers) {
		String[] arr = numbers.split(",");
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = Integer.valueOf(arr[i]);
		}
		return result;
	}
}
