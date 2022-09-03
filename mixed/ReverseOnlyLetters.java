class Solution {
    public String reverseOnlyLetters(String s) {
        Stack<Character> stack=new Stack<>();
        for(char c:s.toCharArray()){
            if( (c>=65 && c<=90) || (c>=97 && c<=122) ){ // a-z A-Z
                stack.push(c);
            }
        }
        char[] arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c=arr[i];
            if( (c>=65 && c<=90) || (c>=97 && c<=122) ){ 
                arr[i]=stack.pop();
            }
        }
        return new String(arr);
        
    }
}
