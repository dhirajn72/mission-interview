class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {

        int res=0;  
        String[] arr=text.split(" ");
        if(brokenLetters==null|| brokenLetters.length()==0)
            return arr.length;

        for(String str:arr){
            Set<Character> set=new HashSet<>();
            for(char c:str.toCharArray()){
                set.add(c);
            }
            boolean flag=true;
            for(char c:brokenLetters.toCharArray()){
                if(set.contains(c)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                res++;
            }
        }
        return res;
    }
}
