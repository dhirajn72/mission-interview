class Solution {
    public String freqAlphabets(String s) {
        if(s==null||s.length()==0)
            return "";
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"a");map.put(2,"b");
        map.put(3,"c");map.put(4,"d");
        map.put(5,"e");map.put(6,"f");
        map.put(7,"g");map.put(8,"h");
        map.put(9,"i");map.put(10,"j");
        map.put(11,"k");map.put(12,"l");
        map.put(13,"m");map.put(14,"n");
        map.put(15,"o");map.put(16,"p");
        map.put(17,"q");map.put(18,"r");
        map.put(19,"s");map.put(20,"t");
        map.put(21,"u");map.put(22,"v");
        map.put(23,"w");map.put(24,"x");
        map.put(25,"y");map.put(26,"z");
        StringBuilder sb=new StringBuilder();
        Stack<Character> charStack=new Stack<>();
        for(int i=0;i<s.length();i++){
            charStack.push(s.charAt(i));
        }
        while(!charStack.isEmpty()){
            if(charStack.peek()=='#'){
                charStack.pop();
                char c1=charStack.pop();
                char c2=charStack.pop();
                String val=c2+""+c1;
                sb.append(map.get(Integer.valueOf(val)));
            }
            else{
                sb.append(map.get(Integer.valueOf(charStack.pop()+"")));
            }
        }
        return sb.reverse().toString();

    }
}
