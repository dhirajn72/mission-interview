import java.util.Arrays;

public class MaximumSumArrayAfterKNegation {
		public static int largestSumAfterKNegations(int[] A, int K) {
			Arrays.sort(A);
			for (int i = 0; K > 0 && i < A.length && A[i] < 0; ++i, --K)
				A[i] = -A[i];
			int res = 0, min = Integer.MAX_VALUE;
			for (int a : A) {
				res += a;
				min = Math.min(min, a);
			}
			return res - (K % 2) * min * 2;
		}

	public static void main(String[] args) {
		int[] arr={4,-2,3};
		System.out.println(largestSumAfterKNegations(arr,3));
		//int[] arr={3,-1,0,2};
		//System.out.println(largestSumAfterKNegations(arr,3));
	}


/*

-2,3,4
5
-2

5-




*/
}
