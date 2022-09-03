import java.util.ArrayList;
import java.util.List;

public class PalindromePartioning {
	static List<List<String>> result = new ArrayList<>();
	public static void main(String[] args) {
		String s = "aaba";
		List<List<String>> result = partion(s);
		System.out.println(result);
	}

	private static List<List<String>> partion(String s) {
		backtrack(s, 0, new ArrayList<String>());
		return result;
	}
	static void backtrack(String s, int start, List<String> list){
		if(start == s.length()){
			result.add(new ArrayList<>(list));
			return;
		}
		else{
			for(int i = start; i < s.length(); i++){
				if(isPalindrome(s, start, i)){
					list.add(s.substring(start, i + 1));
					backtrack(s, i + 1, list);
					list.remove(list.size() - 1);
				}
			}
		}
	}
	static boolean isPalindrome(String s, int start, int end){
		while (start <= end){
			if(s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
