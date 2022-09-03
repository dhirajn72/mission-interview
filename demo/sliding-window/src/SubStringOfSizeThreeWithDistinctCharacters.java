public class SubStringOfSizeThreeWithDistinctCharacters {
    public int countGoodSubstrings(String s) {
       int result = 0;
       if(s == null || s.isEmpty() || s.length() < 3)
           return result;

       for(int i = 3 ; i <= s.length(); i++){
           for(int j = 0; j <= s.length() - i; j++){
               int k = i + j ;
               String str = s.substring(j, k);
               if(str.charAt(0) != str.charAt(1) && str.charAt(1) != str.charAt(2))
                   result++;
           }
       }
       return result;
    }
}
