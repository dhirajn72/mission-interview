class Solution {
    List<List<String>> result=new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtrack(new ArrayList<>(),s,0);
        return result;
    }
    void backtrack(List<String> list,String str,int start){
        if(start==str.length()){
            result.add(new ArrayList<>(list));
            return;
        }
        else{
            for(int i=start;i<str.length();i++){
                if(isPalindrome(str,start,i)){
                    list.add(str.substring(start,i+1));
                    backtrack(list,str,i+1);
                    list.remove(list.size()-1);
                }
            }
        }
    }
    boolean isPalindrome(String str,int i,int j){
        while(i<j){
            if(str.charAt(i)!=str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
