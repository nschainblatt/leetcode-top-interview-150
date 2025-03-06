import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums = new int[] {1,1,1,2,2,3};
		int[] expected = new int[] {1,1,2,2,3,-1};
		int k = s.removeDuplicates(nums);
		assert k == 5 && Arrays.equals(Arrays.copyOfRange(nums, 0, k), Arrays.copyOfRange(expected, 0, k)) : String.format("k: %d | nums: %s | expected: %s", k, Arrays.toString(nums), Arrays.toString(expected));
	}
}

class Solution {
    public int removeDuplicates(int[] nums) {
		int r = 0;
		int l = 0;
		while (r < nums.length) {
			int count = 1;
			while (r+1 < nums.length && nums[r]== nums[r+1]) {
				r++;
				count++;
			}

			for (int i = 0; i < Math.min(2, count); i++) {
				nums[l] = nums[r];
				l++;
			}
			r++;
		}
		return l;

    }
}
