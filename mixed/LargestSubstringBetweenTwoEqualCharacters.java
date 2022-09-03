class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        int n=s.length();
        int result=-1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n-i;j++){
                int k=i+j;
                String sub=s.substring(j,k);
                System.out.println(sub);
                if(sub.charAt(0)==sub.charAt(sub.length()-1)){
                    result=Math.max(result,sub.length()-2);
                }
            }
        }
        return result;  
    }
}

/*
"scayofdzca"


*/
