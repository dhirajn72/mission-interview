class Solution {
    public String reverseWords(String s) {
        int n=s.length();
        String[] arr=s.split(" ");
        StringBuilder sb=new StringBuilder();

        for(String str:arr){
            char[] ch=new char[str.length()];
            int index=0;
            for(int i=str.length()-1;i>=0;i--){
                ch[index++]=str.charAt(i);
            }
            sb.append(new String(ch)).append(" ");
        }
        return sb.toString().trim();
    }
}
