class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        if(words==null||words.length==0)
            return new ArrayList<>();
        List<String> result=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.compute(word,(K,V)->V==null?1:V+1);
        }
        System.out.println(map);
        map=map.entrySet()
                .stream()
                .sorted((Map.Entry.<String, Integer>comparingByValue().reversed()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        System.out.println(map);
        Queue<String> keys=new LinkedList<>();
        Set<String> keySet=map.keySet();
        for(String key:keySet)
            keys.offer(key);

        System.out.println(keys);
        while(k-->0){
            if(!keys.isEmpty())
                result.add(keys.poll());
        }
        Collections.sort(result);
        return result;
    }
}
