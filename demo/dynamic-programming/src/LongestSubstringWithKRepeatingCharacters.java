public class LongestSubstringWithKRepeatingCharacters {
	static public int longestSubstring(String s, int k) {
		System.out.println(s);
		int[] arr = new int[26];
		for(char c : s.toCharArray()){
			arr[c - 'a']++;
		}
		int i = 0;
		boolean valid = true;
		for(i = 0; i < s.length() && valid; i++){
			if(arr[s.charAt(i) - 'a'] < k){
				valid = false;
				break;
			}
		}
		if(valid)
			return s.length();

		int left = longestSubstring(s.substring(0, i), k);
		int right = longestSubstring(s.substring(i + 1, s.length()), k);
		return Math.max(left, right);
	}

	public static void main(String[] args) {
		String str = "ababbc";
		System.out.println(longestSubstring(str, 2));
	}
}
