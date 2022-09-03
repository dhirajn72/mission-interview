class Solution {
    public int countGoodSubstrings(String s) {
        int n=s.length();
        boolean flag=false;
        int result=0;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                if(sub.length()<3)
                    continue;
                if(sub.length()==3){
                    if(sub.charAt(0)!=sub.charAt(1) && sub.charAt(0)!=sub.charAt(2)
                        && sub.charAt(1)!=sub.charAt(2))
                        result++;
                }
                if(sub.length()>3){
                    flag=true;
                    break;
                }
            }
            if(flag)
                break;
        }
        return result;
        
    }
}
