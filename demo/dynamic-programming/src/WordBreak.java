import java.util.Arrays;
import java.util.List;

public class WordBreak {
	static public boolean wordBreak(String s, List<String> wordDict) {
		int n=s.length();
		boolean[] dp=new boolean[n+1];
		dp[0]=true;
		for(int i=1;i<=n;i++){
			for(int j=0;j<i;j++){
				if(dp[j] && wordDict.contains(s.substring(j,i))){
					dp[i]=true;
					break;
				}
			}

		}
		return dp[n];
	}

	public static void main(String[] args) {
		String str = "leetcode";
		List<String> wordDict = Arrays.asList(new String[]{"leet","code"});
		boolean result = wordBreak(str, wordDict);
		System.out.println(result);
	}
}
