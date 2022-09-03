package lineardp;

public class BuyAndSellWithCooling {
	static public int maxProfit(int[] prices) {
		int profit1 = 0, profit2 = 0;
		for(int i = 1; i < prices.length; i++){
			int temp = profit1;
			profit1 = Math.max(profit1 + prices[i] - prices[i - 1], profit2);
			profit2 = Math.max(profit2, temp);
		}
		return Math.max(profit1, profit2);
	}

	public static void main(String[] args) {
		int[] prices = {1,2,3,0,2};
		System.out.println(maxProfit(prices));

	}
}
