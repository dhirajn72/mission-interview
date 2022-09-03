class Solution {
    public String sortSentence(String s) {
        if(s==null||s.length()==0)
            return s;

        int n=s.length();
        String[] arr=s.split(" ");
        Map<Integer,String> map=new TreeMap<>();
        for(String str:arr){
            int key =  Integer.valueOf(str.charAt(str.length()-1));
            String value=str.substring(0,str.length()-1);
            map.put(key,value);
        }
        StringBuilder sb=new StringBuilder();
        for(int key:map.keySet()){
            sb.append(map.get(key)).append(" ");
        }
        return sb.toString().trim();
        
    }
}
