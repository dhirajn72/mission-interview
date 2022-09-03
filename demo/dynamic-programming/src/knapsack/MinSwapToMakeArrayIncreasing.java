package knapsack;

import java.util.Arrays;

public class MinSwapToMakeArrayIncreasing {

	static int[][] dp;

	static public int minSwap(int[] A, int[] B) {
		dp = new int[A.length][2];
		for (int[] row: dp)
			Arrays.fill(row, -1);
		return minSwapHelper(A, B, 0, -1, -1, 0);
	}

	static private int minSwapHelper(int[] A, int[] B, int i, int prevA, int prevB, int swapped) {
		if(i == A.length)
			return 0;
		if(dp[i][swapped] != -1)
			return dp[i][swapped];

		int minSwaps = Integer.MAX_VALUE;
		if(A[i] > prevA && B[i] > prevB) {
			minSwaps = minSwapHelper(A, B, i + 1, A[i], B[i], 0);
		}
		swap(A, B, i); // this will swap the elements of A and B on the ith index
		if(A[i] > prevA && B[i] > prevB) {
			minSwaps = Math.min(minSwaps, 1 + minSwapHelper(A, B, i + 1, A[i], B[i], 1) );
		}
		swap(A, B, i); // this will revert back the swaps, bringing to original positions
		dp[i][swapped] = minSwaps;
		return minSwaps;
	}

	static private void swap(int[] A, int[] B, int i) {
		int t = A[i];
		A[i] = B[i];
		B[i] = t;
	}

	public static void main(String[] args) {
		int[] nums1 = {1,3,5,4}, nums2 = {1,2,3,7};
		System.out.println(minSwap(nums1, nums2));
	}
}
