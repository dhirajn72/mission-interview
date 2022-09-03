class Solution {
    public String[] reorderLogFiles(String[] logs) {
        Map<String,String> map=new HashMap<>();
        for(String log:logs){
            if(log.startsWith("let")){
                String[] arr=log.split(" ",2);
                map.put(arr[0],arr[1]);
            }
        }
        map=map.entrySet().stream().sorted((e1,e2)-> e1.getValue().compareTo(e2.getValue()))
            .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)-> e1,LinkedHashMap::new));
        String[] result=new String[logs.length];
        int index=0;
        for(String str:map.keySet()){
            result[index++]= str+" "+map.get(str);
        }
        map=new TreeMap<>();
        for(String log:logs){
            if(log.startsWith("dig")){
                String[] arr=log.split(" ",2);
                map.put(arr[0],arr[1]);
            }
        }
        for(String str:map.keySet()){
            result[index++]= str+" "+map.get(str);
        }
        return result;
        
    }
}
