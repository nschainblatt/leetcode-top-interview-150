import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String actual = s.longestCommonPrefix(new String[] {});
		String expected = "";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.longestCommonPrefix(new String[] {""});
		expected = "";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.longestCommonPrefix(new String[] {"flower","flow","flight"});
		expected = "fl";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.longestCommonPrefix(new String[] {"dog","racecar","car"});
		expected = "";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.longestCommonPrefix(new String[] {"a"});
		expected = "a";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.longestCommonPrefix(new String[] {"reflower","flow","flight"});
		expected = "";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);
	}
}

class Solution {
	public String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		if (strs.length == 1) return strs[0];

		String longest = "";
		String first = strs[0];
		for (int k = 0; k < first.length(); k++) {
			char oc = first.charAt(k);

			for (int j = 1; j < strs.length; j++) {
				String inner = strs[j]; 
				if (k >= inner.length() || oc != inner.charAt(k)) {
					return longest;
				}
			}

			longest += oc;
		}

		return longest;
	}
}
