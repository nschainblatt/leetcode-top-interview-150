import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		int[] input = new int[] {1,2,3,4,5,6,7};
		int[] expected = new int[] {5,6,7,1,2,3,4};
		s.rotate(input, 3);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));

		input = new int[] {1,2};
		expected = new int[] {1,2};
		s.rotate(input, 2);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));
	}
}

class Solution {
	public void rotate(int[] nums, int k) {

		int[] output = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			output[((i+k)%(nums.length))] = nums[i];
		}

		for (int i = 0; i < output.length; i++) {
			nums[i] = output[i];
		}
	}

	public void swap(int[] array, int i, int j) {
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

}
