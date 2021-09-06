class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits==null|| digits.length()==0)
            return result;
        String[] map={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        combinations(digits,map);
        return result;
    }

    void combinations(String digits,String[] map){
        Queue<String> q=new LinkedList<>();
        q.offer("");
        while(!q.isEmpty()){
            String next=q.poll();
            if(next.length()==digits.length())
                result.add(next);
            else{
                int length=next.length();
                int digit=Integer.valueOf(digits.charAt(length)+"");
                String alpha=map[digit];
                for(int i=0;i<alpha.length();i++){
                    String val=next+alpha.charAt(i);
                    q.offer(val);
                }
            }
        }
    }
}


/*
23


*/
