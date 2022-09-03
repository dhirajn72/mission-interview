public class ReverseString {
	static String reverse(String s){
		if(s == null || s.isEmpty())
			return "";
		return reverse(s, s.length() - 1 );
	}
	static String reverse(String s, int n){
		if( n == 0)
			return ""+s.charAt(n);
		return s.charAt(n) + reverse(s, n - 1);
	}
	public static void main(String[] args){
		String res = "hello";
		System.out.println(reverse(res));
	}
}
