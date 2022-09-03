package bitmasking;

public class HammingDistance {
	public static void main(String[] args) {
		System.out.println(hammingDistance(1,4));
	}
	public static int hammingDistance(int x, int y) {
        int val=x^y;
        int res=0;
        while(val!=0){
            int mod=val%2;
            if(mod==1)
                res++;
            val=val/2;
        }
		return res;
	}
}
