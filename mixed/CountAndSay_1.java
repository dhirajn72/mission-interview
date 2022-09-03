public class CountAndSay_1{
    public static void main(String[] args){
        int n=Integer.valueOf(args[0]);
        countAndSay(n);
    }
    static void countAndSay(int n){
        if(n==0)
            return ;
        String s="1";
        System.out.println(s);
        while(n-->1){
            StringBuilder sb=new StringBuilder();
            int count=0;    
            for(int i=0;i<s.length();i++){
                count=1;
                while(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                    count++;
                    i++;
                }
                sb.append(count).append(s.charAt(i));
            }
            s=sb.toString();
            System.out.println(s);
        }
    }
}
