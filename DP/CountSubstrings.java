class Solution {
    public int countSubstrings(String s) {
        if(s==null || s.length()==0)
            return 0;
        int n=s.length();
        int res=0;
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
               boolean result= isPalindrome(s,i,j);
               if(result)
                   res++;
            }
        }
        return res;
    }

    boolean isPalindrome(String s,int i,int j){
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else
                break;
        }
        return i>j || s.charAt(i)==s.charAt(j);
    }
}
