class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return result;
        backtrack(s,new ArrayList<>(),0);
        return result;
    }
    void backtrack(String s,List<String> list,int start){
        if(start==s.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            if(isPalindrome(s,start,i)){
                list.add(s.substring(start,i+1));
                backtrack(s,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
    boolean isPalindrome(String s, int start,int end){
        int i=start;
        int j=end;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;    
        }
        return true;
    }
}
