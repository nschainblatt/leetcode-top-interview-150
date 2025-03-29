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
			paperCounts[Math.min(paperCounts.length - 1, citation)]++;
		}

		int h = paperCounts.length - 1; // Represents the cited count
		int paperCounter = paperCounts[h]; // Papers with this exact cited count

		while (paperCounter < h) {
			h--;
			paperCounter += paperCounts[h];
		}

		return h;
	}
}
