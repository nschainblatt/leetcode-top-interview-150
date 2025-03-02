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

		if (nums2.length == 0) {
			return;
		}

		int nums2Pointer = 0;
		int nums1RealNumberCounter = m;

		for (int i = 0; i < nums1.length; i++) {

			if (nums2Pointer > nums2.length - 1) {
				break;
			}

			int num1 = nums1[i];
			int num2 = nums2[nums2Pointer];

			if (nums1RealNumberCounter > 0) {
				nums1RealNumberCounter--;
			}

			if (num2 <= num1) {
				shift(nums1, i);
				nums1[i] = num2;
				nums1RealNumberCounter++;
				nums2Pointer++;

			} else if (num1 == 0 && nums1RealNumberCounter == 0) {
				// Reached zeroes
				nums1[i] = num2;
				nums2Pointer++;
			}



		}

    }


    public void shift(int[] nums1, int start) {
		// nums1: 1, 2, 3, 0, 0, 0
		// start: 1
		// nums1: 1, 0, 2, 3, 0, 0 (after shift)

		for (int i = nums1.length - 1; i > start; i--) {
			swap(nums1, i, i - 1);
		}


    }

   public void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
