class Solution {
    public int countCharacters(String[] words, String chars) {
        int n=chars.length();
        boolean flag=true,flag_1=false;
        int res=0;
        for(String word:words){
            flag=true;
            flag_1=false;
            int[] arr=new int[123];
            for(char c:chars.toCharArray()){
                arr[c]=arr[c]+1;
            }
            for(char c:word.toCharArray()){
                if(arr[c]==0){
                    flag_1=true;
                    break;
                }
                arr[c]=arr[c]-1;
            }
            if(flag_1)
                continue;
            int count=0;
            for(int i=0;i<word.length();i++){
                if(arr[word.charAt(i)]<0 ){
                    flag=false;
                    break;
                }
                count++;
            }
            if(flag && count==word.length()){
                res+=word.length();
            }
        }
        return res;
    }
}
