class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {

        backtrack(new ArrayList<>(),s,0);
        return result;
    }
    void backtrack(List<String> list,String s,int start){
        if(start==s.length()){
            result.add(new ArrayList<>(list));
        }
        else{
            for(int i=start;i<s.length();i++){
                if(isPalindrome(s,start,i)){
                    list.add(s.substring(start,i+1));
                    backtrack(list,s,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }

    boolean isPalindrome(String str,int i,int j){
        while( i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
