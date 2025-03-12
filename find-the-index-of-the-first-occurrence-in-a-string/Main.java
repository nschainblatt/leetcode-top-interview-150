import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int actual = s.strStr("sadbutsad", "sad");
		int expected = 0;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);

		actual = s.strStr("leetcode", "leeto");
		expected = -1;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);

		actual = s.strStr("aaa", "aaaa");
		expected = -1;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);

		actual = s.strStr("mississippi", "issip");
		expected = 4;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);

		actual = s.strStr("mississippi", "issipi");
		expected = -1;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);

		actual = s.strStr("mississippi", "pi");
		expected = 9;
		assert expected == actual : String.format("expected: %d actual: %d", expected, actual);
	}
}

class Solution {
	public int strStr(String haystack, String needle) {

		if (needle.length() > haystack.length()){
			return -1;
		}

		int needlePointer = 0;
		int beginningMarker = -1;

		int i = 0;
		while (i < haystack.length() && needlePointer < needle.length()) {

			if (haystack.charAt(i) == needle.charAt(needlePointer)) {
				if (beginningMarker == -1) {
					beginningMarker = i;
				}

				needlePointer++;
			} else {
				if (beginningMarker != -1) {
					i = beginningMarker;
				}

				needlePointer = 0;
				beginningMarker = -1;
			}

			i++;
		}

		return needlePointer != needle.length() ? -1 : beginningMarker;
	}
}
