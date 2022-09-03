package multithreadin;

import java.util.Arrays;
import java.util.Comparator;


public class ArraysSortTest {
	public static void main(String[] args){
		Integer[] arr = {1,10,11,12,13,2,3,4,5,6,7,8,9};
		Comparator<Integer> comparator = (a, b) -> a.toString().compareTo(b.toString());
		Arrays.sort(arr, comparator);
		System.out.println(Arrays.toString(arr));

		System.out.println("--------");
		Integer[] arr1 = new Integer[13];
		int index = 0;
		for(int i = 1; i <= 13; i++){
			arr1[index++] = i;
		}
		System.out.println(Arrays.toString(arr1));
		Arrays.sort(arr1, comparator);
		System.out.println(Arrays.asList(arr1));
		System.out.println("=====Calculate power======");
		int power = pow(5, 5);
		assert Math.pow(5, 5) == power : "It is same";
		System.out.println(power);
	}
	static int pow(int n, int p){
		if(p == 0)
			return 1;
		else
			return n * pow(n , p - 1);
	}
}
