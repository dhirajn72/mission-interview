public class RunLengthEncoding{
    static public String encode(String str){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++){
            int j = i, count = 1;
            while(j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)){
                count++;
                j++;
            }
            i = j;
            sb.append(str.charAt(i));
            sb.append(count);
        }
        return sb.toString();
    }
     static public void encodetimes(int n){
        String str = "1";
        while(n-- > 0){
            StringBuilder sb = new StringBuilder();
             for(int i = 0; i < str.length(); i++){
                 int j = i, count = 1;
                 while(j + 1 < str.length() && str.charAt(j) == str.charAt(j + 1)){
                     count++;
                     j++;
                 }
                 i = j;
                 sb.append(str.charAt(i));
                 sb.append(count);
             }
             str = sb.toString();
             System.out.println(str);
        }
    }
    public static void main(String[] args){
        System.out.println("aaaabbdhdjeiuh : " +  encode("aaaabbdhdjeiuh"));
        System.out.println("aabdhdjeiuh : " + encode("aabdhdjeiuh"));
        System.out.println("aaaabbdiuh : " + encode("aaaabbdiuh"));
        System.out.println("bdhdjeiuh : " + encode("bdhdjeiuh"));
        System.out.println("djeiuh : " + encode("djeiuh"));
        System.out.println("iuh : " + encode("iuh"));
        System.out.println("------------");
        encodetimes(Math.max(10, Integer.valueOf(args[0])));
    }
}
