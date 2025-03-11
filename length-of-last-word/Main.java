import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		int output = s.lengthOfLastWord("");
		int expectedOutput = 0;
		assert expectedOutput == output : String.format("Expected: %d Actual: %d", expectedOutput, output);

		output = s.lengthOfLastWord("a");
		expectedOutput = 1;
		assert expectedOutput == output : String.format("Expected: %d Actual: %d", expectedOutput, output);

		output = s.lengthOfLastWord("luffy is still joyboy");
		expectedOutput = 6;
		assert expectedOutput == output : String.format("Expected: %d Actual: %d", expectedOutput, output);

		output = s.lengthOfLastWord("luffy is still joyboy         ");
		expectedOutput = 6;
		assert expectedOutput == output : String.format("Expected: %d Actual: %d", expectedOutput, output);

		output = s.lengthOfLastWord("luffy is still joyboy     i   ");
		expectedOutput = 1;
		assert expectedOutput == output : String.format("Expected: %d Actual: %d", expectedOutput, output);
	}
}

class Solution {
	public int lengthOfLastWord(String s) {
		int length = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (length == 0 && s.charAt(i) == ' ') {
				continue;
			} else if (length != 0 && s.charAt(i) == ' ') {
				break;
			} else {
				length++;
			}
		}

		return length;
	}
}
