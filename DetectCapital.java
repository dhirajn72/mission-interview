class Solution {
    public boolean detectCapitalUse(String word) {
        if(word==null||word.length()==0)
            return true;
        if(word.length()==1)
            return true;
        char first=word.charAt(0);
        char second=word.charAt(1);
        if(first>=65 && first<=90 && second>=65 &&  second<=90){
            for(int i=2;i<word.length();i++){
                char c=word.charAt(i);
                if(c>=97)
                    return false;
            }
        }
        else if(first>=65 && first<=90){
            for(int i=1;i<word.length();i++){
                char c=word.charAt(i);
                if(c<=90)
                    return false;
            }
        }
        else if(first>=97 && first<=122){
            for(int i=1;i<word.length();i++){
                char c=word.charAt(i);
                if(c<=90)
                    return false;
            }
        }
        return true;
    }
}
