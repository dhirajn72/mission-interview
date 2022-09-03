class Solution {
    public String destCity(List<List<String>> paths) {
        if(paths==null||paths.size()==0)
            return null;
        Map<String,String> map=new HashMap<>();
        for(List<String> pair:paths){
            map.put(pair.get(0),pair.get(1));
        }
        for(String val:map.values()){
            if(map.get(val)==null)
                return val;
        }
        return null;
    }
}
