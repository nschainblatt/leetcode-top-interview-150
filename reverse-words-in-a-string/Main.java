import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		String input = "  hello    world  ";
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
		String[] array = Arrays.stream(s.trim().split(" ")).filter(t -> !t.isEmpty()).toArray(String[]::new);
		reverse(array);
		return String.join(" ", array);
	}


	public void reverse(String[] array) {
		int start = 0;
		int end = array.length-1;
		while (start < end) {
			String temp = array[start];
			array[start] = array[end];
			array[end] = temp;
			start++;
			end--;
		}
	}

}
