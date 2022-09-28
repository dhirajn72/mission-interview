package bitmasking;

public class ShiftOperatorTest {
	public static void main(String[] args) {
		int a=1;
		System.out.println(a<<2);
		System.out.println(a>>1);
		System.out.println(a>>100); // to the right shift beyond the last digit will always be zero.
		//for(int i = 1; i <= 100; i++)
		//System.out.println( i << a); // to the right shift beyond the last digit will always be zero.
		a = 0;
		System.out.println(a>>1);
		System.out.println(a << 1);
		System.out.println(a << 2);
		System.out.println(a << 4);
		a = 3;
		System.out.println(a << 2);
		System.out.println("-------------");
		System.out.println((1 << a) - 1);
	}
}
