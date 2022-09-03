package bitmasking;

public class CountingBits {
	public int[] countBits(int n) {
		int[] result=new int[n+1];
		for(int i=0;i<=n;i++){
			result[i]=getOnes(i);
		}
		return result;
	}
	int getOnes(int  n){
		int res=0;
		while(n!=0){
			int mod=n%2;
			if(mod==1)res++;
			n=n/2;
		}
		return res;
	}
}
