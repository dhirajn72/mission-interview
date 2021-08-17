class Solution {
    List<String> result=new ArrayList<>();
    public List<String> letterCasePermutation(String s) {
       if(s==null||s.length()==0)
           return result;

        Queue<String> q=new LinkedList<>();
        q.offer(s);
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i)))
                continue;

            int size=q.size();
            for(int j=0;j<size;j++){
                String curr=q.poll();
                char[] chars=curr.toCharArray();

                chars[i]=Character.toUpperCase(chars[i]);
                q.offer(String.valueOf(chars));

                
                chars[i]=Character.toLowerCase(chars[i]);
                q.offer(String.valueOf(chars));
            }
        }
       return new ArrayList<>(q);
   }
}
