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
		int maxPointer = 0;

		for (int i = 1; i < prices.length; i++) {

			if (prices[i] < prices[minPointer]) {
				minPointer = i;
			}

			if (i > maxPointer || prices[i] > prices[maxPointer]) {
				maxPointer = i;
			}

			if (maxPointer > minPointer && prices[maxPointer] - prices[minPointer] > profit) {
				profit = prices[maxPointer] - prices[minPointer];
			}

		}

		return Math.max(profit, 0);
	}
}
