import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		// Test
		int[] test = new int[] {1, 2, 3};
		s.swap(test, 0, 0);
		assert Arrays.equals(new int[] {1, 2, 3}, test);

		s.reverse(test);
		assert Arrays.equals(new int[] {3, 2, 1}, test);


		test = new int[] {1, 2, 3, 4};
		s.reverse(test);
		assert Arrays.equals(new int[] {4, 3, 2, 1}, test);

		int[] input = new int[] {1,2,3,4,5,6,7};
		int[] expected = new int[] {5,6,7,1,2,3,4};
		s.rotate(input, 3);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));

		input = new int[] {1,2};
		expected = new int[] {1,2};
		s.rotate(input, 2);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));

		input = new int[] {1};
		expected = new int[] {1};
		s.rotate(input, 2);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));

		input = new int[] {1,2,3,4,5,6};
		expected = new int[] {5,6,1,2,3,4};
		s.rotate(input, 2);
		assert Arrays.equals(expected, input) : String.format("expected: %s actual: %s", Arrays.toString(expected), Arrays.toString(input));
	}
}

class Solution {
	public void rotate(int[] nums, int k) {

		if (nums.length == 1) return;

		k = k%nums.length;

		int count = 0;
		int index = 0;
		int prev = nums[0];

		// Reverse entire array
		reverse(nums);

		// Reverse 0:k-1
		reverse(nums, 0, k - 1);

		// Reverse k:last-index
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] array) {
		int left = 0;
		int right = array.length - 1;
		while (left < right) {
			swap(array, left, right);
			left++;
			right--;
		}
	}

	public void reverse(int[] array, int start, int end) {
		while (start < end) {
			swap(array, start, end);
			start++;
			end--;
		}
	}

	public void swap(int[] array, int i , int j) {
		if (array[i] == array[j]) return;
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

}
