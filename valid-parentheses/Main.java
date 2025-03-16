import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		boolean result = s.isValid("]");
		assert !result;
	}
}

class Solution {
	public boolean isValid(String s) {

		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char bracket = s.charAt(i);
			if (bracket == '(' || bracket == '{' || bracket == '[') {
				stack.push(bracket);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char openingBracket = stack.pop();
				if ((bracket == ')' && openingBracket != '(') || (bracket == '}' && openingBracket != '{') || (bracket == ']' && openingBracket != '[')) {
					return false;
				}
			}
		}

		return stack.isEmpty();
	}
}
