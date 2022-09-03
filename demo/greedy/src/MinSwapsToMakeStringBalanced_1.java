public class MinSwapsToMakeStringBalanced_1 {
	static public int minSwaps(String s) {
		int stack = 0;
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '['){
				stack++;
			}
			else{
				if(stack > 0)
					stack--;
			}
		}
		return (stack + 1) / 2 ;
	}

	public static void main(String[] args) {
		//String str = "][][";
		String str = "]]][[[";
		//String str = "[]";
		System.out.println(minSwaps(str));
	}
}
