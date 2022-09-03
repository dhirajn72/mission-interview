class Solution {
    public String sortSentence(String s) {
        if(s==null || s.length()==0)
            return s;
        Map<Integer,String> map=new TreeMap<>();
        String[] arr=s.split(" ");
        for(int i=0;i<arr.length;i++){
            int key=arr[i].charAt(arr[i].length()-1);
            StringBuilder sb=new StringBuilder();
            for(int j=0;j<arr[i].length()-1;j++){
                sb.append(arr[i].charAt[j]);
            }
            map.put(key,sb.toString());
        }
        StringBuilder sb=new StringBuilder();
        for(int key:map.keySet()){
            sb.append(map.get(key)).append(" ");
        }
        return sb.toString().trim();
    }
}
