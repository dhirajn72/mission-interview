public class MinimumTimeToTypeWordUsingTypeWriter {
	static public int minTimeToType(String word) {
		int result = word.length();
		char prev = 'a';
		for(int i = 0; i < word.length(); i++){
			char curr = word.charAt(i);
			int diff = Math.abs(curr - prev);
			result += Math.min(diff, 26 - diff);
			prev = curr;
		}
		return result;
	}

	public static void main(String[] args) {
		String word = "cat";
		System.out.println(minTimeToType(word));
	}
}
