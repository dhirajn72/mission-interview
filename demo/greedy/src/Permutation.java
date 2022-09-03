import java.util.Arrays;

public class Permutation {
	static void permutation(String str, int start){
		if(start == str.length()){
			System.out.println(str);
			return;
		}
		for(int i = start; i < str.length(); i++) {
			str = swap(str, i, start);
			permutation(str, start + 1);
			str = swap(str, i, start);
		}
	}
	static String swap(String str, int i, int j){
		char[] arr = str.toCharArray();
		char temp = arr[i];
		arr[i] =  arr[j];
		arr[j] = temp;
		return new String(arr);
	}
	static void permutation(int[] arr, int start){
		if(start == arr.length){
			System.out.println(Arrays.toString(arr));
			return;
		}
		for(int i = start; i < arr.length; i++){
			swap(arr, i, start);
			permutation(arr, start + 1);
			swap(arr, i, start);
		}
	}
	static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		//permutation("ABC",0);
		permutation(new int[]{1, 2, 3}, 0);
	}
}
