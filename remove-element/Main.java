
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		
		System.out.println("1.");
		int[] nums = new int[]{3,2,2,3};
		int[] expected = new int[]{2,2,-1,-1}; // NOTE: -1 represents the removed elements leaving an empty space that is disregarded
		int k = s.removeElement(nums, 3);
		Arrays.sort(nums, 0, k);
		assert 2 == k && Arrays.equals(Arrays.copyOfRange(expected, 0, k), Arrays.copyOfRange(nums, 0, k)) : String.format("k: %d | nums: %s",k,Arrays.toString(nums));
		System.out.println("PASSED");
		System.out.printf("k: %d | nums: %s\n", k, Arrays.toString(nums));

		System.out.println("2.");
		nums = new int[]{3,3,2,2};
		expected = new int[]{2,2,-1,-1};
		k = s.removeElement(nums, 3);
		Arrays.sort(nums, 0, k);
		assert 2 == k && Arrays.equals(Arrays.copyOfRange(expected, 0, k), Arrays.copyOfRange(nums, 0, k)) : String.format("k: %d | nums: %s",k,Arrays.toString(nums));
		System.out.println("PASSED");
		System.out.printf("k: %d | nums: %s\n", k, Arrays.toString(nums));

		System.out.println("3.");
		nums = new int[]{0,1,2,2,3,0,4,2};
		expected = new int[]{0,1,4,0,3,-1,-1,-1};
		k = s.removeElement(nums, 2);
		Arrays.sort(nums, 0, k);
		Arrays.sort(expected, 0, k);
		assert 5 == k && Arrays.equals(Arrays.copyOfRange(expected, 0, k), Arrays.copyOfRange(nums, 0, k)) : String.format("k: %d | nums: %s",k,Arrays.toString(nums));
		System.out.println("PASSED");
		System.out.printf("k: %d | nums: %s\n", k, Arrays.toString(nums));

		System.out.println("4.");
		nums = new int[]{2,2,3};
		expected = new int[]{3,2,2};
		k = s.removeElement(nums, 2);
		Arrays.sort(nums, 0, k);
		Arrays.sort(expected, 0, k);
		assert 1 == k && Arrays.equals(Arrays.copyOfRange(expected, 0, k), Arrays.copyOfRange(nums, 0, k)) : String.format("k: %d | nums: %s",k,Arrays.toString(nums));
		System.out.println("PASSED");
		System.out.printf("k: %d | nums: %s\n", k, Arrays.toString(nums));
	}


}

class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
