package bitmasking;
public class PrimeNumberOfSetBitsInBinaryRepresentation{
    public int countPrimeSetBits(int left, int right) {
        int res=0;
        for(int i=left;i<=right;i++){
            int ones=getOnes(i);
            if(ones==2 || ones==3){
                res++;
                continue;
            }
            if( !(ones%2==0 || ones%3 ==0 )){
                res++;
            }
        }
        return res;
    }
    int getOnes(int n){
        int res=0;
        while(n!=0){
            int mod=n%2;
            if(mod==1){
                res++;
            }
            n=n/2;
        }
        return res;
    }
}
