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

		Map<Integer, Integer> countMap = new HashMap<>();

		for (int num : nums) {
			if (countMap.containsKey(num)) {
				countMap.put(num, countMap.get(num)+1);
			} else {
				countMap.put(num, 1);
			}
			if (countMap.get(num) >= nums.length / 2.0) {
				return num;}
		}

		return -1;
	}
}
