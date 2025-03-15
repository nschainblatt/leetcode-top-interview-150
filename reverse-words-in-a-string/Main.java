import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		String input = "  hello world  ";
		String expected = "world hello";
		String actual = s.reverseWords(input);
		assert expected.equals(actual) : String.format("expected: '%s' actual: '%s'", expected, actual);
		System.out.println("1. passed");

		input = "the sky is blue";
		expected = "blue is sky the";
		actual = s.reverseWords(input);
		assert expected.equals(actual) : String.format("expected: '%s' actual: '%s'", expected, actual);
		System.out.println("2. passed");

	}
}

class Solution {
	public String reverseWords(String s) {
		StringBuilder builder = new StringBuilder();
		int left = -1;
		int right = -1;

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == ' ') {
				if (right != -1) { // encountered a space and right is set, were in a word
					builder.insert(0, s.substring(left, right+1) + " ");
					left = -1;
					right = -1;
				}
				continue;
			} else {
				// in a word
				right = i;
				if (left == -1) { // only set left at the beginning of a word
					left = i;
				}
			}
		}

		if (left != -1 && right != -1) { // add any leftover if the last word didn't have a space after it
			builder.insert(0, s.substring(left, right+1) + " ");
		}

		return builder.toString().trim();
	}
}
