import java.util.ArrayList;
import java.util.List;

public class FindtheMinimumNumberofFibonacciNumbersWhoseSumIsK {
    static public int findMinFibonacciNumbers(int k) {
    	if(k < 2 ) return k;
    	int first = 1, second = 1;
    	while(second <= k){
    	    second = first + second;
    	    first = second - first;
        }
    	return 1 + findMinFibonacciNumbers(k - first);
    }

	public static void main(String[] args) {
		System.out.println(findMinFibonacciNumbers(7));
	}
}