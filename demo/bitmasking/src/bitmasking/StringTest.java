package bitmasking;

public class StringTest {
	public static void main(String[] args) {
		System.out.println("asdfg".substring(2));
		System.out.println("asdfg".substring(0,0));
		System.out.println("asdfg".substring(0,1));
		System.out.println("asdfg".substring(1));
		//System.out.println("asdfg".substring(6));
		System.out.println("----");
		String s="11";
		System.out.println((int)s.charAt(0)-'0');
		System.out.println((int)s.charAt(0));
		System.out.println(s.charAt(0)-'0');
		System.out.println(Character.isLowerCase('0'));
		System.out.println(Character.toUpperCase('0'));
		StringBuilder sb=new StringBuilder();
		sb.append("qwerty");
		System.out.println(Character.toUpperCase(sb.charAt(5)));
		System.out.println(sb);
		System.out.println(Character.toUpperCase("abcde".charAt(2)));

	}
}
