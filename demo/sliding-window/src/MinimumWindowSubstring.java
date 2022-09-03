import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static void main(String[] args){
        String str = "ADOBECODEBANC", t = "ABC";
        System.out.println(minWindow(str, t));
    }
    static public String minWindow(String s, String t) {
        if(s.length() < t.length()) return "";
        String result = "", currWindow = "";
        for(int i = 0; i < s.length(); i++){
            currWindow += s.charAt(i) + "";
            while(currWindow.length() >= t.length() && isValid(currWindow, t)){
                System.out.println("Window : " + currWindow);
                result = result.isEmpty() || currWindow.length() <= result.length() ? currWindow : result;
                currWindow = currWindow.substring(1);
            }
        }
        return result;
    }
    static boolean isValid(String str, String t){
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++){
            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }
        for(int i = 0; i < t.length(); i++){
            map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
        }
        for(int i = 0; i < t.length(); i++){
            if(map.get(t.charAt(i)) < 0) return false;
        }
        return true;
    }
}


/*


ADOBECODEBANC

ABC


1 = ADOBEC
2 = DOBECODEBA
3 = CODEBA
4 = ODEBANC
5 = BANC


Test Cases
============

"ADOBECODEBANC"
"ABC"
"a"
"a"
"a"
"aa"
"a"
"b"
"bbaa"
"aba"
"acbbaca"
"aba"
"ab"
"A"
"aaaaaaaaaaaabbbbbcdd"
"abcdd"

*/

