import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoatsToSavePeople {
	public static void main(String[] args) {
		int[] people={2,2,3,1};
		int n=3;
		System.out.println(numRescueBoats(people,n));
	}
	static public int numRescueBoats(int[] people, int limit) {
		Arrays.sort(people);
		int i,j;
		for( i = 0, j=people.length-1 ; i<=j ; j-- ) {
			if(people[i]+people[j]<=limit)
				i++;
		}
		return people.length-j-1;
	}
}
