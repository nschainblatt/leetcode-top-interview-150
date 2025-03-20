import java.util.*;

public class Main {

	public static void main(String[] args) {
		Solution s = new Solution();

		int[] nums = new int[] {1,2,3,4};
		int[] actual = s.productExceptSelf(nums);
		int[] expected = new int[] {24,12,8,6};
		assert Arrays.equals(expected, actual) : String.format("expected: %s, actual: %s", Arrays.toString(expected), Arrays.toString(actual));
		System.out.println("passed #1");

		nums = new int[] {-1,1,0,-3,3};
		actual = s.productExceptSelf(nums);
		expected = new int[] {0,0,9,0,0};
		assert Arrays.equals(expected, actual) : String.format("expected: %s, actual: %s", Arrays.toString(expected), Arrays.toString(actual));
		System.out.println("passed #2");
	}
}

class Solution {
	public int[] productExceptSelf(int[] nums) {
		int[] output = new int[nums.length];
		
		int prefix = 1;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			output[i] = prefix;
			prefix *= num;
		}

		int postfix = 1;
		for (int i = nums.length - 1; i >= 0; i--) {

			int num = nums[i];
			output[i] = postfix * output[i];
			postfix *= num;

		}

		return output;
	}
}
