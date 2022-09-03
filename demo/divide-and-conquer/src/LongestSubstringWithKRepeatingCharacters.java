public class LongestSubstringWithKRepeatingCharacters {
	class Solution {
		/*public int longestSubstring(String s, int t) {
			int n=s.length();
            int max=Integer.MIN_VALUE;
			for(int i=1;i<=n;i++){
				for(int j=0;j<=n-i;j++){
					int k=i+j;
					String str=s.substring(j,k);
                    if(str.length()<t)
                        break;
                    char[] arr=str.toCharArray();
                    int[] lookup=new int[123];
                    for(char c: arr){
                        lookup[c]=++lookup[c];
                    }
                    boolean flag=true;
                    StringBuilder sb=new StringBuilder();
                    for(char c :arr){
                        if(lookup[c]>=t){
                            sb.append(c);
                        }
                        else{
                            flag=false;
                            break;
                        }
                    }
                    if(flag){
                        max=Math.max(max,sb.length());
                    }

				}
			}
			return max;
		}
        */

		public int longestSubstring(String s, int t) {
            int[] arr=new int[26];
            for(char c: s.toCharArray()){
                arr[c-'a']++;
            }
            int start=0;
            int end=s.length()-1;
            boolean valid=true;
            int i=0;
            for(i=0;i<s.length() && valid;i++){
                if(arr[s.charAt(i)-'a']<t){
                    valid=false;
                    break;
                }
            }
            if(valid){
                return s.length();
            }
            int left=longestSubstring(s.substring(0,i),t);
            int right=longestSubstring(s.substring(i+1,s.length()),t);
            return Math.max(left,right);
        }
	}
}
