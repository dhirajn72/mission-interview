import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParenthesis {
	static Map<String, List<Integer>> dp = new HashMap<>();
	static public List<Integer> diffWaysToCompute(String expression) {
		if(dp.containsKey(expression))
			return dp.get(expression);
		List<Integer> list = new ArrayList<>();
		for(int i = 0; i < expression.length(); i++){
			char c = expression.charAt(i);
			if(c == '+' || c == '-' || c == '*'){
				List<Integer> left = diffWaysToCompute(expression.substring(0, i));
				List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

				for(int v1 : left){
					int res = 0;
					for(int v2 : right){
						if(c == '*')
							res = v1 * v2;
						if(c == '+')
							res = v1 + v2;
						if(c == '-')
							res = v1 - v2;

						list.add(res);
					}
				}
			}
		}
		if(list.isEmpty())
			list.add(Integer.valueOf(expression));
		dp.put(expression, list);
		return list;
	}

	public static void main(String[] args) {
		System.out.println(diffWaysToCompute("2*3-4*5"));
	}
}
