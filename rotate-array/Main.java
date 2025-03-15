class Solution {
	public void rotate(int[] nums, int k) {

		if (nums.length == 1) return;

        k = k%nums.length;

		int count = 0;
		int index = 0;
		int prev = nums[0];

		// 1, 2, 3, 4, 5, 6, 7
		System.out.println(Arrays.toString(nums));

		// Reverse entire array
		reverse(nums);
		System.out.println(Arrays.toString(nums));
		// 7, 6, 5, 4, 3, 2, 1

		// Reverse 0:k (exclusive)
		reverse(nums, 0, k);
		System.out.println(Arrays.toString(nums));
		// 5, 6, 7, 4, 3, 2, 1

		// Reverse k:end
		reverse(nums, k, nums.length);
		System.out.println(Arrays.toString(nums));
		// 5, 6, 7, 1, 2, 3, 4
	}

	public void reverse(int[] array) {
        int left = 0;
        int right = array.length - 1;
		for (int i = 0; i < array.length / 2; i++) {
			swap(array, i, array.length - 1 - i);
		}
	}

	public void reverse(int[] array, int start, int end) {
		for (int i = 0; i < (end-start) / 2; i++) {
			swap(array, i + start, end - 1 - i);
		}
	}

	public void swap(int[] array, int i , int j) {
		if (array[i] == array[j]) return;
		array[i] = array[i] ^ array[j];
		array[j] = array[i] ^ array[j];
		array[i] = array[i] ^ array[j];
	}

}
