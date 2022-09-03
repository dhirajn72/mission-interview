public class SplitStringInBalancedString {
	class Solution {
		public int balancedStringSplit(String s) {
			if(s==null)
				return 0;
			int count=0,res=0;
			for(char c: s.toCharArray()){
				if(c=='L'){
					count++;
				}
				else{
					count--;
				}
				if(count==0)
					res++;
			}
			return res;

		}
	}
}
