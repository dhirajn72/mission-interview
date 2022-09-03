import java.util.Arrays;

public class SlidingWindowLoops {
	public static void main(String[] args) {
		//looptest();
		lambdaTest();
	}

	private static void looptest() {
		int[] arr = {1,2,3,4,5};
		int n = arr.length;
		for(int L = n - 1; L >= 0; L--){
			for(int R = L; R < n; R++){
				for(int i = L; i <= R; i++){
					//System.out.println(Arrays.toString(Arrays.copyOfRange(arr, L, i)));
					System.out.print(arr[i]+",");
				}
				System.out.println();
			}
		}
	}
	private static void lambdaTest(){
		int[][] arr = {{1,2}, {7, 8}, {4, 5}};
		System.out.println(Arrays.deepToString(arr));
		Arrays.sort(arr, (a, b) -> a[1] - b[1]);
		System.out.println(Arrays.deepToString(arr));
	}
}
