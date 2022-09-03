public class ReverseNumber{
    static int reverse(int n){
        int remainder=0;
        while(n!=0){
            remainder=remainder*10;
            remainder += n%10;
            n=n/10;
        }
        return remainder;
    }
    public static void main(String[] args){
        System.out.println(reverse(12346789));
    }
}
