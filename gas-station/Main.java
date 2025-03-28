import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] gas = new int[] { 1, 2, 3, 4, 5 };
		int[] cost = new int[] { 3, 4, 5, 1, 2 };
		int output = s.canCompleteCircuit(gas, cost);
		assert output == 3 : output;

		gas = new int[] { 2, 3, 4 };
		cost = new int[] { 3, 4, 3 };
		output = s.canCompleteCircuit(gas, cost);
		assert output == -1 : output;

		gas = new int[] { 2 };
		cost = new int[] { 3 };
		output = s.canCompleteCircuit(gas, cost);
		assert output == -1 : output;

		gas = new int[] { 3 };
		cost = new int[] { 3 };
		output = s.canCompleteCircuit(gas, cost);
		assert output == 0 : output;

		gas = new int[] { 4 };
		cost = new int[] { 3 };
		output = s.canCompleteCircuit(gas, cost);
		assert output == 0 : output;
	}
}

class Solution {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 1 && cost[0] <= gas[0]) {
			return 0;
		}

		int start = 0;
		while (start < gas.length) { // give every gas station a chance to be the startin point until a solution
						// is found or the end is reached
			int tank = gas[start];
			int price = cost[start];

			int current = (start + 1) % gas.length;
			while (current != start) { // go through clockwise from the start
				tank -= price;
				if (tank < 0) {
					break;
				}
				tank += gas[current];

				price = cost[current];
				current = (current + 1) % gas.length;
			}
			if (current == start && tank - price >= 0) {
				return start;
			}

			if (current > start) {
				start = current;
			} else {
				break;
			}
		}

		return -1;
	}
}
