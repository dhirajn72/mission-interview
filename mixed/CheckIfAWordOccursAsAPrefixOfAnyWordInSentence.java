class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int result=0;
        int index=0;
        String[] arr=sentence.split(" ");
        for(String word:arr){
            index++;
            if(word.startsWith(searchWord))
                return index;
        }
        return -1;
        
    }
}
