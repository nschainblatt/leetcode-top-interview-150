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
		if (strs.length == 0) {
			return "";
		} else if (strs.length == 1) {
			return strs[0];
		}
		String longest = "";
		int occurrences = 0;

		// for every string in array
		// for every string after above string in array
		// for every character in string
		// compare outer string characters to inner string characters by position if possible

		// ["flower","flow","flight"]
		for (int i = 0; i < strs.length; i++) {
			String outer = strs[i];

			String current = "";

			for (int k = 0; k < outer.length(); k++) {
				char oc = outer.charAt(k);
				int count = 0;

				for (int j = i + 1; j < strs.length; j++) {
					String inner = strs[j]; 
					if (k < inner.length() && oc == inner.charAt(k)) {
						count++;
					} else {
						break;
					}
				}

				if (count != strs.length -1 ) break;

				if (count > 0) {
					current += oc;
				}

				if (count >= occurrences && current.length() > longest.length()) {
					longest = current;
					occurrences = count;
				} else {
					break;
				}

			}

		}




		return longest;
	}
}
