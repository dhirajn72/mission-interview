import java.util.Arrays;

public class ArraysCopy {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 0, 3)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 4, 5)));
		System.out.println(Arrays.toString(Arrays.copyOfRange(arr, 2, 5)));
	}
}
