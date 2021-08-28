class Solution {
    public String longestNiceSubstring(String s) {
        int n=s.length();
        if(n==1)
            return "";
        if(n==2){
            if(s.charAt(0)>=65 && s.charAt(0)<=90 && s.charAt(0)+32==s.charAt(1))
                return s;
            if(s.charAt(0)>=97 && s.charAt(0)<=122 && s.charAt(0)-32==s.charAt(1))
                return s;
        }
        String result="";
        int[] arr=new int[130];
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                int count=0;
                for(int l=0;l<sub.length();l++){
                    arr[sub.charAt(l)]=sub.charAt(l);
                }
                boolean flag=true;
                for(int m=0;m<sub.length();m++){
                    if(sub.charAt(m)>=65 && sub.charAt(m)<=90){
                        if(arr[sub.charAt(m)+32]==0){
                            flag=false;
                            break;
                        }
                    }
                    else if(sub.charAt(m)>=97 && sub.charAt(m)<=122){
                        if(arr[sub.charAt(m)-32]==0){
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag && result.length()<sub.length())
                    result=sub;
                Arrays.fill(arr,0);
            }
        }
        return result;
    }
}
