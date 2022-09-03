public class TwoEggDrop {
	static public int twoEggDrop(int n) {
		int[] dp = new int[n + 1];
		int floor = 1;
		boolean flag = false;
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <=i ; j++){
				if(floor > n){
					flag = true;
					break;
				}
				dp[floor] = i;
				floor++;
			}
			if(flag)
				break;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(twoEggDrop(10));
	}
}
