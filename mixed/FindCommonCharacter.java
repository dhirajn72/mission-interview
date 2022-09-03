class Solution {
    public List<String> commonChars(String[] words) {
        int n=words.length;
        String word=words[0];
        List<String> result=new ArrayList<>();
        
        for(char c:word.toCharArray()){
            int count=0;
            for(int i=1;i<n;i++){
                if(words[i].contains(c+"")){
                    int index=words[i].indexOf(c+"");
                    StringBuilder sb=new StringBuilder(words[i]);
                    words[i]=sb.deleteCharAt(index).toString();
                    count++;
                }
                else
                    break;
            }
            if(n-1==count){
                result.add(c+"");
            }
            count=0;
        }
        return result;
    }
}
