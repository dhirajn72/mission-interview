package bitmasking;

public class XOR {
	public static void main(String[] args){
		int a=5;
		int b=6;
		System.out.println(a^b);
		System.out.println(2^3^4^7);
		System.out.println("--------");
		System.out.println(a ^ b);
		System.out.println(~(a ^ b));
		System.out.println(a == b);
	}
}
