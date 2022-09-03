class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character,Integer> map=new HashMap<>();
        for(String word:words){
            for(char c:word.toCharArray()){
                if(map.containsKey(c)){
                    map.put(c,map.get(c)+1);
                }
                else
                    map.put(c,1);
            }
        }
        for(int count:map.values()){
            if(count%words.length!=0)
                return false;
        }
        return true;
        
    }
}
