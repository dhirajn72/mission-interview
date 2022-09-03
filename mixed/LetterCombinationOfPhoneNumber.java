class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null||digits.length()==0)
            return result;
        String[] table={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combination(digits,table);
        return result;
    }

    public void combination(String digits,String[] table){
        Queue<String> q=new LinkedList<>();
        q.offer("");
        while(!q.isEmpty()){
            String s=q.poll();
            if(s.length()==digits.length()){
                result.add(s);
            }
            else{
                String digit=digits.charAt(s.length())+"";
                String val=table[Integer.valueOf(digit)];
                for(int i=0;i<val.length();i++){
                    q.offer(s+val.charAt(i));
                }
            }
        }
    }
}
