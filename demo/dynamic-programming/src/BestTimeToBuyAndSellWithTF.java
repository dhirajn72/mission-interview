public class BestTimeToBuyAndSellWithTF {
	static public int maxProfit(int[] prices, int fee) {
		if (prices == null || prices.length == 0) {
			return 0;
		}
		int buy = -prices[0], sell = 0;
		for (int i = 1; i < prices.length; i++) {
			buy = Math.max(buy, sell - prices[i]);
			sell = Math.max(sell, buy + prices[i] - fee);
		}
		return Math.max(buy, sell);
	}

	public static void main(String[] args) {
		int[] prices = {1,3,2,8,4,9};
		int fee = 2;
		System.out.println(maxProfit(prices, fee));
	}

}
