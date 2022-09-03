class Solution {
    public String removeDuplicates(String s) {
        int n=s.length();
        Stack<Character> stack=new Stack<>();
        for(int i=n-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else if(stack.peek()==s.charAt(i))
                stack.pop();
            else{
                stack.push(s.charAt(i));
            }
        }
        StrinBuilder sb=new StringBuilder();
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }
}
