class Solution {
    public int maxNumberOfBalloons(String text) {
        if(text==null||text.length()<6)
            return 0;
        int result=0;
        String word="balloon";
        StringBuilder sb=new StringBuilder();
        char[] arr=text.toCharArray();

        while(true){
            for(char c:word.toCharArray()){
                for(int j=0;j<arr.length;j++){
                    if(arr[j]==c){
                        arr[j]=' ';
                        sb.append(c);
                        break;
                    }
                }
            }
            if(sb.toString().equals(word)){
                result++;
            }
            int count=0;
            for(char c:arr){
                if(c!=' '){
                    count++;
                }
            }
            if(count<7 || sb.length()<7)
                break;
            sb=new StringBuilder();
        }
        return result;
    }
}
