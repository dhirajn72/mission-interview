package recursion;

public class Test1 {
	public static void main(String[] args) {
		method(5);
	}

	static void method(int n){
		if( n == 0){
			System.out.println("Hit the base case :"+ n);
			return;
		}
		method(n - 1);
		System.out.println(n);
		//method(n - 1);
	}
}
