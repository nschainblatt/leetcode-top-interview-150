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
		Map<Character, Character> bracketMap = new HashMap<>();
		bracketMap.put('(',')');
		bracketMap.put('{','}');
		bracketMap.put('[',']');

		for (int i = 0; i < s.length(); i++) {
			char bracket = s.charAt(i);
			if (bracketMap.containsKey(bracket)) {
				stack.push(bracket);
			} else if (stack.isEmpty() || bracket != bracketMap.get(stack.pop())) {
				return false;
			}
		}

		return stack.isEmpty();
	}
}
