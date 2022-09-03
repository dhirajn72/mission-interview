package lineardp;

import java.util.Arrays;

public class MinCostTravelTickets {
	static public int mincostTickets(int[] days, int[] costs) {
		boolean[] isTravelDay = new boolean[366];
		for(int day : days){
			isTravelDay[day] = true;
		}

		int[] dp = new int[366];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for(int i = 1; i < 366; i++){
			if(!isTravelDay[i]){
				dp[i] = dp[i - 1];
				continue;
			}
			dp[i] = Math.min(dp[i], costs[0] + dp[i - 1]);
			if(i - 7 >= 0){
				dp[i] = Math.min(dp[i], costs[1] + dp[i - 7]);
			}
			else{
				dp[i] = Math.min(dp[i], costs[1]);
			}
			if(i - 30 >= 0){
				dp[i] = Math.min(dp[i], costs[2] + dp[i - 30]);
			}
			else{
				dp[i] = Math.min(dp[i], costs[2]);
			}
		}
		return dp[365];
	}

	public static void main(String[] args) {
		int[] days = {1,4,6,7,8,20}, costs = {2,7,15};
		System.out.println(mincostTickets(days, costs));
	}

}
