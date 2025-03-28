import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int[] citations = new int[] { 3, 0, 6, 1, 5 };
		int actual = s.hIndex(citations);
		assert 3 == actual : actual;

		citations = new int[] { 1, 2, 3, 4, 5 };
		actual = s.hIndex(citations);
		assert 3 == actual : actual;

		citations = new int[] { 0, 0, 0, 0, 0 }
		;
		actual = s.hIndex(citations);
		assert 0 == actual : actual;

	}
}

// First sort the array in ascending order
//
// Then go over every citations, get it's value
//
// If the value isn't zerio, is greater than the current max, and the amount of
// reports with this value or greater is also greater than the max, then update
// the max
//
// This isn't the most optimal solution, but is the easiest solution that first
// came to mind, will explore other options later.

class Solution {
	public int hIndex(int[] citations) {

		if (citations.length == 1) {
			return Math.min(citations[0], 1);
		}

		bubblesort(citations);

		int max = 0;

		// citations.length - i > max (this includes the current element in the answer)
		for (int i = 0; i < citations.length; i++) {
			if (citations[i] > max && citations.length - i > max) {
				max = Math.min(citations[i], citations.length - i);
			}
		}

		return max;
	}

	private void bubblesort(int a[]) {
		// sort asc
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length - i - 1; j++) {
				if (a[j + 1] < a[j]) {
					swap(a, j + 1, j);
				}
			}
		}
	}

	private void swap(int[] a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
}
