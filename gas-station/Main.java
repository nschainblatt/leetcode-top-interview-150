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
		int gasSum = 0;
		int costSum = 0;
		for (int i = 0; i < gas.length; i++) {
			gasSum += gas[i];
			costSum += cost[i];
		}

		if (gasSum < costSum) {
			return -1;
		}

		// At this point we know there is a solution guranteed
		int start = 0;
		int tank = 0;

		for (int current = start; current < gas.length; current++) {
			tank += gas[current] - cost[current];
			if (tank < 0) {
				tank = 0;
				start = current + 1;
			}
		}

		return start;
	}
}
