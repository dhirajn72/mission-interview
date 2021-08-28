class Solution {
    public int numberOfSubstrings(String s) {
        if(s==null||s.isEmpty())
            return 0;

        int result=0;
        int n=s.length();
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                int aCount=0,bCount=0,cCount=0;
                boolean flag=false;
                int start=0;
                int end=sub.length()-1;
                while(start<end){
                    if(sub.charAt(start)=='a'){
                        aCount++;
                        start++;
                    }
                    else if(sub.charAt(start)=='b'){
                        bCount++;
                        start++;
                    }
                    else if(sub.charAt(start)=='c'){
                        cCount++;
                        start++;
                    }
                    else if(sub.charAt(end)=='a'){
                        aCount++;
                        end--;
                    }
                    else if(sub.charAt(end)=='b'){
                        bCount++;
                        end--;
                    }
                    else if(sub.charAt(end)=='c'){
                        cCount++;
                        end--;
                    }
                    if(aCount>=1 && bCount>=1 && cCount>=1){
                        flag=true;
                        break;
                    }
                }
                if(flag){
                    result++;
                    flag=false;
                }
            }
        }
        return result;
    }
}
