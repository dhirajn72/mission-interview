public class TwoFurthestHouseWithDifferentColor {

	static public int maxDistance(int[] A) {
		int n = A.length, i = 0, j = n - 1;
		while (A[0] == A[j])
			j--;
		while (A[n - 1] == A[i])
			i++;
		return Math.max(n - 1 - i, j);
	}
	public static void main(String[] args){
		int[] arr={1,1,1,6,1,1,1};
		System.out.println(maxDistance(arr));
	}
}
