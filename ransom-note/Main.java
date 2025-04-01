import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		assert !s.canConstruct("aabc", "ab");
	}
}

class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> characterCount = new HashMap<>();
		int i;
		char c;

		for (i = 0; i < magazine.length(); i++) {
			c = magazine.charAt(i);
			characterCount.merge(c, 1, Integer::sum);
		}

		for (i = 0; i < ransomNote.length(); i++) {
			if (characterCount.compute(ransomNote.charAt(i), (k, v) -> (v == null) ? -1 : v - 1) == -1) {
				return false;
			}
		}

		return true;
	}
}
