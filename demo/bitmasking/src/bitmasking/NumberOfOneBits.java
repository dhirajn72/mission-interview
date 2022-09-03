package bitmasking;

public class NumberOfOneBits {
    // you need to treat n as an unsigned value
    public static  int hammingWeight(int n) {
        int res=0;
        for(int j=0; j<32; j++){
            if(((n>>j) & 1) != 0)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        int n=1011;
        System.out.println(hammingWeight(n));
        int val=(int)Math.pow(2,2);
        System.out.println(val);
    }
}
