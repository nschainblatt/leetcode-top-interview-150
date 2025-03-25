import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] { 2, 3, 1, 1, 4 };
		assert s.canJump(nums);
		System.out.println("passed #1");

		nums = new int[] { 3, 2, 1, 0, 4 };
		assert !s.canJump(nums);
		System.out.println("passed #2");

	}
}

class Solution {
	public boolean canJump(int[] nums) {
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int currIndex = stack.pop();
			if (visited.contains(currIndex)) {
				continue;
			}

			if (currIndex == nums.length - 1) {
				return true;
			}
			for (int j = 1; j <= nums[currIndex]; j++) {
				int i = currIndex + j;
				if (i < nums.length) {
					stack.push(i);
				}
			}
			visited.add(currIndex);
		}

		return false;
	}
}
