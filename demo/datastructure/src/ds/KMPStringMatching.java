package ds;

import java.util.ArrayList;
import java.util.List;

public class KMPStringMatching {
	List<Integer> indices = new ArrayList<>();
	List<Integer> kmpmatching(String pat, String txt) {
		int M = pat.length();
		int N = txt.length();
		int lps[] = new int[M];
		computeLPSArray(pat, lps); // Build longest prefix suffix tree.
		int i = 0;
		int j = 0;
		while (i < N) {
			if (pat.charAt(j) == txt.charAt(i)) {
				j++;// if matching then increment i and j both by one for the next character match
				i++;
			}
			if (j == M) { // After incrementing , if it matches the length of pat, it means the whole pattern is available.
				System.out.println("Found pattern "
						+ "at index " + (i - j));
				indices.add(i - j); // save the matching index
				j = lps[j - 1]; // reset j to find out the next match
			}
			else if (i < N && pat.charAt(j) != txt.charAt(i)) {
				if (j != 0)
					j = lps[j - 1];
				else
					i = i + 1;
			}
		}
		return indices;
	}

	void computeLPSArray(String pat, int lps[]) {
		int len = 0;
		int i = 1;
		while (i < pat.length()) {
			if (pat.charAt(i) == pat.charAt(len)) {
				len++; // if matchin then increment len
				lps[i] = len; // set the matching len length to found lps[i'th] index
				i++; // then move i to the next location
			} else{
				if (len != 0) { // if not matching and length is not 0, then move j  to last matching char, and that will be available in lps[j - 1]
					len = lps[len - 1];
				} else{
					lps[i] = len; // if not matching and len is also 0, then set 0 to i'th index of lps
					i++;
				}
			}
		}
	}
	public static void main(String args[]) {
		String str = "ABACDABABC";
		String pat = "ABABC";
		str = "ABAAB";
		pat = "BA";

		List<Integer> indices = new KMPStringMatching().kmpmatching(pat, str);
		System.out.println(indices);
	}
}
