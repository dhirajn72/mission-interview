class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result=new ArrayList<>();
        if(digits==null||digits.isEmpty())
            return result;

        String[] letters={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        Queue<String> q=new LinkedList<>();
        q.offer("");
        //23
        while(!q.isEmpty()){
            String let=q.poll();
            int length=let.length();
            if(length==digits.length()){
                result.add(let);
            }
            else{
                int digit=Integer.valueOf(digits.charAt(length)+"");
                String letter=letters[digit];
                for(int i=0;i<letter.length();i++){
                    String res=let+String.valueOf(letter.charAt(i));
                    q.offer(res);
                }
            }
        }
        return result;
    }
}
