class Solution {
    public String mergeAlternately(String word1, String word2) {

        int n=word1.length();
        int m=word2.length();
        char[] arr=new char[n+m];
        int index=0;
        int l1=0;
        int l2=0;
        boolean flag=true;
        while(l1<n && l2<m){
            if(flag){
                arr[index++]=word1.charAt(l1);
                l1++;
                flag=false;
            }
            else{
                arr[index++]=word2.charAt(l2);
                l2++;
                flag=true;
            }
        }
        if(l1>=n){
            for(int i=l2;i<m;i++)
                arr[index++]=word2.charAt(i);
        }   

        if(l2>=m){
            for(int i=l1;i<n;i++)
                arr[index++]=word1.charAt(i);
        }   
        return new String(arr);
    }
}
