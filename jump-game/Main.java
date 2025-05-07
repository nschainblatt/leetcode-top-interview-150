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
        int target = nums.length - 1;

        for (int i = target-1; i >=0; i--) {
            if (i + nums[i] >= target)  {
                target = i;
            }
        }
        
        return target == 0;
	}
}
