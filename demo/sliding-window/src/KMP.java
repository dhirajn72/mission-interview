import java.util.Arrays;

public class KMP {
	static void kmp(String str, String patt){
		int n = str.length();
		int m = patt.length();
		int[] lps = new int[m];
		computeLps(patt, lps);
		int i = 0, j = 0;
		while(i < n){
			if(str.charAt(i) == patt.charAt(j)){
				i++;
				j++;
			}
			if(j == m){
				System.out.println("Pattern found at : " + (i - j));
				j = lps[j - 1];
			}
			else if( i < n && str.charAt(i) != patt.charAt(j)){
				if( j != 0){
					j = lps[j - 1];
				}
				else{
					i++;
				}
			}
		}
	}

	static void computeLps(String patt, int[] lps){
		int len = 0;
		int i = 1;
		while(i < patt.length()){
			if( patt.charAt(i) == patt.charAt(len)){
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if(len != 0){
					len = lps[len - 1];
				}
				else{
					lps[i] = 0;
					i++;
				}
			}
		}
		System.out.println(Arrays.toString(lps));
	}
	public static void main(String args[]) {
		String txt = "ababc";
		//String txt = "aaaba    aaab aaaba  aaaba  aaaba  aaaba  aaaba";
		String pat = "ab";
		//String pat = "aaaba";
		kmp(txt, pat);


	}
}
