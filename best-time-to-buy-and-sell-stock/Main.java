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
		int leftPointer = 0;

		for (int rightPointer = 1; rightPointer < prices.length; rightPointer++) {
			profit = Math.max(prices[rightPointer] - prices[leftPointer], profit);
			if (prices[rightPointer] < prices[leftPointer]) {
				leftPointer = rightPointer;
			}
		}

		return Math.max(profit, 0);
	}
}
