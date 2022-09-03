import java.util.HashSet;
import java.util.Set;

public class LongestNiceSubstring {
	static public String longestNiceSubstring(String s) {
		if(s == null || s.length() < 2)
			return "";

		Set<Character> set = new HashSet<>();
		for(char c : s.toCharArray()){
			set.add(c);
		}
		for(int i = 0; i < s.length(); i++){
			System.out.println(i);
			if(set.contains(Character.toLowerCase( s.charAt(i))) && set.contains(Character.toUpperCase(s.charAt(i))) ){
				continue;
			}
			String sub1 = longestNiceSubstring(s.substring(0, i));
			String sub2 = longestNiceSubstring(s.substring(i + 1, s.length() ));
			return sub1.length() >= sub2.length() ? sub1 : sub2;
		}
		return s;
	}
	public static void main(String[] args){
		String str = "YazaAay";
		String result = longestNiceSubstring(str);
		System.out.println(Math.max(Double.NEGATIVE_INFINITY, -1/1));
		System.out.println(result);
	}
}
