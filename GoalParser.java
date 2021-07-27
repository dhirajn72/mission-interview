class Solution {
    public String interpret(String command) {
        if(command==null||command.isEmpty())
            return null;

        StringBuilder sb=new StringBuilder();
        Stack<Character> stack=new Stack<>();
        
        for(int i=0;i<command.length()-1;i++){
            if(command.charAt(i)=='(' && command.charAt(i+1)==')'){
                sb.append('o');
            }
            else if(command.charAt(i)=='('){
                continue;
            }
            else if(command.charAt(i)==')'){
                continue;
            }
            else
                sb.append(command.charAt(i));
        }
        if(command.charAt( command.length()-1 )!=')')
            sb.append( command.charAt(command.length()-1) );
        return sb.toString();
    }
}
