class Solution {
    public String generateTheString(int n) {
        if(n==0)
            return "";
        if(n==1)
            return "a";
        if(n==2)
            return "ab";
        StringBuilder sb=new StringBuilder();
        if(n%2==0){
            for(int i=1;i<n;i++){
                sb.append("a");
            }
            sb.append("b");
            return sb.toString();
        }
        else{
            if( (n-1)%2==0 ){
                 for(int i=1;i<n-1;i++){
                     sb.append("a");
                 }
                 sb.append("b");
                 sb.append("c");
                 return sb.toString();
            }
        }
        return "";
    }
}
