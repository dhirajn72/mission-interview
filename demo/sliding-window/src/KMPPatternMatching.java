import java.util.List;

public class KMPPatternMatching {
    static void kmp(String str, String pat){
        int n = str.length();
        int m = pat.length();
        int[] lps = new int[m];
        computeLps(pat, lps);
        int i = 0;
        int j = 0;
        while(i < str.length()){
            if(str.charAt(i) == pat.charAt(j)){
                i++;
                j++;
            }
            if(j == m){
                System.out.println("Found at: "+ (i - j));
                j = lps[j - 1];
            }
            else if(i < n && str.charAt(i) != pat.charAt(j)){
                if(j != 0){
                    j = lps[j - 1];
                }
                else
                    i++;
            }
        }
    }
    static void computeLps(String pat, int[] lps){
        int len = 0;
        int i = 1;
        while(i < pat.length()){
            if(pat.charAt(i) == pat.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len != 0){
                    len = lps[len - 1];
                }
                else{
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
    public static void main(String args[]) {
        String txt = "ABAABABCA";
        String pat = "ABABC";
        kmp(txt, pat);
    }
}
