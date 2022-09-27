public class CountBits {
	static public int[] countBits(int n) {
		if(n==0)
			return new int[]{0};
		int[] dp=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++){
			if(i%2==0){
				dp[i]=dp[i/2];
			}
			else{
				dp[i]=dp[i/2]+1;
			}
		}
		return dp;
	}

	public static void main(String[] args) {
		System.out.println(countBits(8));
	}

}
