public class MinimumSwapsToMakeStringSame {
	static public int minimumSwap(String s1, String s2) {
		int x = 0, y = 0;
		for(int i = 0; i < s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				if(s1.charAt(i) == 'x')
					x++;
				else
					y++;
			}
		}
		int count = x + y;
		if(count % 2 != 0) return -1;
		return count / 2 + y % 2;
	}

	public static void main(String[] args) {
		//System.out.println(minimumSwap("yy","xx"));
		//System.out.println(minimumSwap("yx","xy"));
		System.out.println(minimumSwap("yx","xx"));
	}
}
