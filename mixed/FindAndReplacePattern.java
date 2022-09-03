class Solution {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result=new ArrayList<>();      
        char[] arr=pattern.toCharArray();
        int[] pat=new int[arr.length];
        Arrays.fill(pat,1);
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1])
                pat[i] += pat[i-1];
        }

        for(String word:words){
            char[] wordArr=word.toCharArray();
            int[] wordPat=new int[wordArr.length];
            Arrays.fill(wordPat,1);
            for(int i=1;i<wordArr.length;i++){
                if(wordArr[i]==wordArr[i-1])
                    wordPat[i]+=wordPat[i-1];
            }
            if(Arrays.equals(pat,wordPat)){
                result.add(word);
            }
        }
        return result;
    }
}
/*
["abc","cba","xyx","yxx","yyx"]
"abc"





*/
