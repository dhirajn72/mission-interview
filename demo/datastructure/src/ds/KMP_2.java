package ds;

import java.util.List;

public class KMP_2 {
	static void kmp(String patt, String str) {
		int n = str.length();
		int m = patt.length();
		int[] lps = new int[m];
		computeLps(patt, lps);

		int i = 0;
		int j = 0;
		while (i < n) {
			if (str.charAt(i) == str.charAt(j)) {
				i++;
				j++;
			}
			if (j == m) {
				System.out.println("Found at :" + (i - j));
				j = lps[j - 1];
			} else if (i < n && str.charAt(i) != str.charAt(j)) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	static void computeLps(String str, int[] lps) {
		int len = 0;
		int i = 1;
		while (i < str.length()) {
			if (str.charAt(i) == str.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					lps[i] = lps[len - 1];
				} else {
					lps[i] = len;
					i++;
				}
			}
		}
	}
	public static void main(String args[]) {
		String str = "ABACDABABC";
		String pat = "ABABC";
		str = "ABABABABAABABABABACAAAAAAA";
		pat = "ABABABAB";
		kmp(pat, str);
	}
}
