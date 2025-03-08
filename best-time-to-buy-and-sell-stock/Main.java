import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] prices = new int[] {7,1,5,3,6,4};
		int profit = s.maxProfit(prices);
		assert profit == 5 : profit;
	}
}

class Solution {
	public int maxProfit(int[] prices) {
		int profit = 0;
		int minPointer = 0;
		int maxPointer = 1;

		while (maxPointer < prices.length) {
			if (prices[minPointer] < prices[maxPointer]) {
				profit = Math.max(profit, prices[maxPointer] - prices[minPointer]);
			} else {
				minPointer = maxPointer;
			}
			maxPointer++;
		}
		return profit;
	}
}
