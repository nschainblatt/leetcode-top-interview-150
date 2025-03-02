import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] nums1 = new int[]{1,2,3,0,0,0};
		int[] nums2 = new int[] {2,5,6};
		s.merge(nums1, 3, nums2, 3);
		assert Arrays.equals(new int[] {1, 2, 2, 3, 5, 6}, nums1) : Arrays.toString(nums1);
		System.out.println(Arrays.toString(nums1));

		nums1 = new int[]{0, 1, 2, 0, 0, 0};
		nums2 = new int[] {3,4,5};
		s.merge(nums1, 3, nums2, 3);
		assert Arrays.equals(new int[] {0, 1, 2, 3, 4, 5}, nums1) : Arrays.toString(nums1);
		System.out.println(Arrays.toString(nums1));

		nums1 = new int[] {1};
		nums2 = new int[] {};
		s.merge(nums1, 1, nums2, 0);
		assert Arrays.equals(new int[] {1}, nums1) : Arrays.toString(nums1);
		System.out.println(Arrays.toString(nums1));

		nums1 = new int[] {0};
		nums2 = new int[] {1};
		s.merge(nums1, 0, nums2, 1);
		assert Arrays.equals(new int[] {1}, nums1) : Arrays.toString(nums1);
		System.out.println(Arrays.toString(nums1));

		nums1 = new int[] {2, 0};
		nums2 = new int[] {1};
		s.merge(nums1, 1, nums2, 1);
		assert Arrays.equals(new int[] {1, 2}, nums1) : Arrays.toString(nums1);
		System.out.println(Arrays.toString(nums1));
	}


}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

		int nums1Pointer = m - 1;
		int nums2Pointer = n - 1;
		int nums1LastPointer = nums1.length - 1;

		while (nums2Pointer >= 0) {

			if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
				nums1[nums1LastPointer] = nums1[nums1Pointer];
				nums1Pointer--;
			} else {
				nums1[nums1LastPointer] = nums2[nums2Pointer];
				nums2Pointer--;
			}

			nums1LastPointer--;

		}
    }
}
