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

		for (int i = 0; i < haystack.length() && needlePointer < needle.length(); i++) {

			System.out.println("h: " + haystack.charAt(i));
			System.out.println("n: " + needle.charAt(needlePointer));
			System.out.println("beginning marker " + beginningMarker);

			if (haystack.charAt(i) == needle.charAt(needlePointer)) {
				if (beginningMarker == -1) {
					beginningMarker = i;
				}

				needlePointer++;
			} else {
				if (beginningMarker != -1) {
					System.out.println("setting i to: " + haystack.charAt(beginningMarker + 1));
					i = beginningMarker; //NOTE not adding 1 here because it will get added next iteration of for loop
				}

				needlePointer = 0;
				beginningMarker = -1;
			}



		}

		return needlePointer != needle.length() ? -1 : beginningMarker;
	}
}
