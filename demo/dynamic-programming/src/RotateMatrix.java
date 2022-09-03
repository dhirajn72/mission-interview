import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateMatrix {
	static public void rotate(int[][] arr) {
		int n=arr.length ;

		for(int i=0;i< (n + 1 )/2;i++){
			for(int j=0;j< n/2;j++){
				int temp=arr[i][j];
				arr[i][j]=arr[n-1-j][i];
				arr[n-1-j][i]=arr[n-1-i][n-1-j];
				arr[n-1-i][n-1-j]=arr[j][n-1-i];
				arr[j][n-1-i]=temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Before rotation: ");
		for(int[] rows : matrix)
			System.out.println(Arrays.toString(rows));
		rotate(matrix);
		System.out.println("After rotation: ");
		for (int[] rows : matrix)
			System.out.println(Arrays.toString(rows));
	}
}
