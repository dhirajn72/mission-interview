package bitmasking;

public class DecimalToBinary {
	public static void main(String[] args){
		int n=4;
		while(n!=0){
			System.out.print(n%2+",");
			n=n/2;
		}
		System.out.println();
		System.out.println(1%2);
	}
}
