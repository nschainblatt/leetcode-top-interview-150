import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		String input = "  hello world  ";
		String expected = "world hello";
		String actual = s.reverseWords(input);
		assert expected.equals(actual) : String.format("expected: '%s' actual: '%s'", expected, actual);

		input = "the sky is blue";
		expected = "blue is sky the";
		actual = s.reverseWords(input);
		assert expected.equals(actual) : String.format("expected: '%s' actual: '%s'", expected, actual);

	}
}

class Solution {
	public String reverseWords(String s) {
		StringBuilder builder = new StringBuilder();

		boolean inWord = false;
		StringBuilder subBuilder = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char curr = s.charAt(i);
			if (curr == ' ') {
				if (inWord) {
					builder.insert(0, subBuilder.toString() + " ");
					subBuilder.delete(0, subBuilder.length());
				}
				inWord = false;
				continue;
			}

			inWord = true;
			subBuilder.append(curr);
		}

		builder.insert(0, subBuilder.toString() + " ");

		return builder.toString().trim();
	}
}
