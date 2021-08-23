class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        if(strs==null||strs.length==0)
            return result;

        Map<String,List<String>> map=new HashMap<>();
        for(String word:strs){
            char[] charArr=word.toCharArray();
            Arrays.sort(charArr);
            String key=new String(charArr);
            if(map.containsKey(key)){
                map.get(key).add(word);
            }
            else{
                List<String> list=new ArrayList<>();
                list.add(word);
                map.put(key,list);
            }
        }
        for(String key:map.keySet()){
            result.add(map.get(key));
        }
        return result;
    }
}
