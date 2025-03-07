import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {2,2,1,1,1,2,2};
		int output = s.majorityElement(nums);
		assert output == 2 : output;
	}
}

class Solution {
	public int majorityElement(int[] nums) {

		int count = 0;
		int value = nums[0];

		for (int num : nums) {
			if (num == value) {
				count++;
			} else {
				count--;
				if (count == -1) {
					value = num;
					count = 1;
				}
			}

		}

		return value;
	}
}
