public class StringDivideTest {
	public static void main(String[] args) {
		String str = "abcd";
		divide(str);
	}
	static String divide(String str){
		for(int i = 0; i < str.length(); i++){
			String s1 = divide(str.substring(0, i));
			String s2 = divide(str.substring(i + 1, str.length()));
			System.out.println(s1 +"::"+ s2);
		}
		return str;
	}
}
