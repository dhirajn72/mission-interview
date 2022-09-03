import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class GenerateParenthesis {
	static public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		backtrack(result, "", 0, 0, n);
		return result;
	}

	static void backtrack(List<String> list, String curr, int open, int close, int max){
		if(curr.length() == max * 2){
			list.add(curr);
			return;
		}
		if(open < max ) backtrack(list, curr + "(", open + 1, close, max);
		if(close < open) backtrack(list, curr + ")", open, close + 1, max);
	}

	public static void main(String[] args) {
		System.out.println(generateParenthesis(2));
	}
}
