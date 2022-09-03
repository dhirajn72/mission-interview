package recursion;

public class Test2 {
	public static void main(String[] args) {
		System.out.println(method("abcde"));
	}
	static String method(String s){
		if(s == null || s.isEmpty()) return "";
		System.out.println(s);
		for (int i = 0; i < s.length(); i++) {
			method(s.substring(0, i));
			method(s.substring(i + 1 , s.length()));
		}
		return "";
	}
}
