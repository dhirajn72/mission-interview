public class KMPPatternMatching{
    static void kmp(String str, String pat){
        int m = pat.length();
        int n = str.length();
        int[] lps = new int[m];
        computelps(pat, lps);
        int i = 0;
        int j = 0;
        while(i < n){
            if(pat.charAt(j) == str.charAt(i)){
                j++;
                i++;
            }
            if(j == m){
                System.out.println("Pattern found at: "+ (i - j));
                j = lps[j - 1];
            }
            else if(i < n && pat.charAt(j) != str.charAt(i)) {
                if(j != 0){
                    j = lps[j - 1];
                }
                else{
                    i++;
                }
            }
        }
    }

    static void computelps(String pat, int[] lps){
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

    public static void main(String[] args){
        String str = "ABACDABABC";
        String pat = "ABABC";
        kmp(str, pat); 

    }

}
