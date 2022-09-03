class Solution {
    int res=0;
    public int numOfStrings(String[] patterns, String word) {
        for(String str:patterns){
            if(str.length()>word.length())
                continue;
            findSubstring(str,word);
        }
        return res;
    }
    void findSubstring(String str,String word){
        int n=word.length();
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=word.substring(j,k);
                if(sub.equals(str)){
                    res++;
                    return;
                }
            }
        }
    }
}
