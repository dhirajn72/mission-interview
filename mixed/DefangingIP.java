class Solution {
    public String defangIPaddr(String address) {
        if(address==null||address.isEmpty())
            return "";
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<address.length();i++){
            if(address.charAt(i)=='.'){
                sb.append("[.]");
            }
            else{
                sb.append(address.charAt(i));
            }
        }
        return sb.toString();
    }
}
