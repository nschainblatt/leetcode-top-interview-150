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

		citations = new int[] { 0, 0, 0, 0, 0 };
		actual = s.hIndex(citations);
		assert 0 == actual : actual;

		citations = new int[] { 11, 15 };
		actual = s.hIndex(citations);
		assert 2 == actual : actual;

		citations = new int[] { 0, 0, 2 };
		actual = s.hIndex(citations);
		assert 1 == actual : actual;

	}
}

class Solution {
	public int hIndex(int[] citations) {

		int[] paperCounts = new int[citations.length + 1];

		for (int citation : citations) {
			if (citation > paperCounts.length - 1) {
				paperCounts[paperCounts.length - 1]++;
			} else {
				paperCounts[citation]++;
			}
		}

		int citationSum = 0;
		for (int i = paperCounts.length - 1; i > 0; i--) {
			citationSum += paperCounts[i];

			if (citationSum >= i) {
				return i;
			}
		}

		return 0;
	}
}
