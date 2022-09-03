class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        Set<String> set1=new HashSet<>();
        Set<String> set2=new HashSet<>();
        List<String>  list=new ArrayList<>();
        for(String s:s1.split(" ")){
            if(set1.contains(s)){
                set1.remove(s);
            }
            else{
                set1.add(s);
            }
        }
        for(String s:s2.split(" ")){
            if(set2.contains(s)){
                set2.remove(s);
            }
            else{
                set2.add(s);
            }
        }

        for(String s:set2){
            if(!set1.contains(s)){
                list.add(s);
            }
        }
        for(String s:set1){
            if(!set2.contains(s)){
                list.add(s);
            }
        }
        String[] result=new String[list.size()];
        int index=0;
        for(String word:list){
            result[index++]=word;
        }
        return result;
    }
}
