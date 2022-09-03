public class CountAndSay{
    static void countAndSay(int n){
        String str = new String("1");
        while(n-- > 1){
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < str.length(); i++) {
                count = 1;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count).append(str.charAt(i));
            }
            str = sb.toString();
            System.out.println(sb);
        }
    }

    public static void main(String[] args) {
        countAndSay(10);
    }
}
