class Solution {
    int result=0;
    public int balancedString(String s) {
        if(s==null||s.length()==0)
            return 0;
        if(s.length()<4)
            return 0;
        int n=s.length();
        
        /*
        for(int i=0;i<n;i+=4){
            String sub="";
            for(int j=0;j<4;j++){
                int k=i+j;
                sub+=s.charAt(k);
            }
            balance(sub);
        }
        */
        balance(s); 
        return result;
    }
    void balance(String s){
        int n=s.length();
        int w=0,e=0,r=0,q=0;
        int min=n/4;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='W')
                w++;
            else if(s.charAt(i)=='E')
                e++;
            else if(s.charAt(i)=='Q')
                q++;
            else if(s.charAt(i)=='R')
                r++;
        }
        if(w<min){
            result+=min-w;
        }
        if(e<min){
            result+=min-e;
        }
        if(q<min){
            result+=min-q;
        }
        if(r<min){
            result+=min-r;
        }
    }
}

/*

"QWER"
"QQWE"
"QQQW"
"QQQQ"
"WWQQRRRRQRQQ"
"WWEQERQWQWWRWWERQWEQ"
"WWQQRRRRQRQQ"
w-1
q-2
r-2


*/
