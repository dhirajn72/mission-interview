import java.util.Arrays;

public class ReverseArrayRecursively {
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		reverse(arr, 0 ,arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	static void reverse(int[] arr, int start, int end){
		if(start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			reverse(arr, ++start, --end);
		}
	}
}
