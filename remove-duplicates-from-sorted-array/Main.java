import java.util.*;

public class Main {
	public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
        int[] expected = new int[]{0,1,2,3,4,-1,-1,-1,-1,-1};
        int k = s.removeDuplicates(nums);
        assert 5 == k && Arrays.equals(Arrays.copyOfRange(nums, 0, k), Arrays.copyOfRange(expected, 0, k)) : String.format("k: %d | nums: %s", k, Arrays.toString(Arrays.copyOfRange(nums, 0, k)));
	}
}

class Solution {
    public int removeDuplicates(int[] nums) {
                if (nums.length == 0 || nums.length == 1) {
                        return nums.length;
                }

                int uniquePointer = 1;
                for (int i = 1; i < nums.length; i++) {
                        if (nums[i] != nums[i-1]) {
                                nums[uniquePointer] = nums[i];
                                uniquePointer++;
                        }
                }

                return uniquePointer;
    }
}
