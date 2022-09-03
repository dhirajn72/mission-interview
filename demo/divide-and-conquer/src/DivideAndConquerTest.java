import java.util.Arrays;

public class DivideAndConquerTest {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		divideAndConquer(arr, 0, arr.length - 1);
	}

	private static void divideAndConquer(int[] arr, int start, int end) {
		for(int i = 0; i < arr.length - 1; i++){
			int[] left = getArray(arr, 0, i);
			int[] right = getArray(arr, i + 1, arr.length - 1);
			System.out.println(Arrays.toString(left) +"::"+ Arrays.toString(right));
		}
	}
	static int[] getArray(int[] arr, int start, int end){
		int len = 0;
		for(int i = start; i <= end; i++){
			len++;
		}
		int[] result = new int[len == 0 ? 1 : len];
		int index = 0;
		for(int i = start; i <= end; i++){
			result[index++] = arr[i];
		}
		return result;
	}
}
