class Solution {
    public String[] findWords(String[] words) {
        int n=words.length;
        String row1="qwertyuiop";
        String row2="asdfghjkl";
        String row3="zxcvbnm";
        List<String> list=new ArrayList<>();

        for(String word:words){
            char[] arr=word.toLowerCase().toCharArray();
            int i=0;
            int count=0;
            while(i<arr.length && row1.contains(arr[i]+"")){
                count++;
                i++;
            }
            if(count==word.length()){
                list.add(word);
                continue;
            }
            count=0;
            i=0;
            while(i<arr.length && row2.contains(arr[i]+"")){
                count++;
                i++;
            }
            if(count==word.length()){
                list.add(word);
                continue;
            }
            count=0;
            i=0;
            while(i<arr.length && row3.contains(arr[i]+"")){
                count++;
                i++;
            }
            if(count==word.length()){
                list.add(word);
            }
        }
        String[] result=new String[list.size()];
        int index=0;
        for(String s:list){
            result[index++]=s;
        }
        return result;

    }
}
