class Solution {
    public boolean isValid(String s) {
        if(s==null||s.length()==0)
            return true;

        Stack<Character> stack=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='}' && !stack.isEmpty() && stack.peek()=='{'){
                stack.pop();
                continue;
            }
            if(s.charAt(i)==')' && !stack.isEmpty() && stack.peek()=='('){
                stack.pop();
                continue;
            }
            if(s.charAt(i)==']' && !stack.isEmpty() && stack.peek()=='['){
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }
        
        if(stack.isEmpty())
            return true;
        return false;
    }
}
