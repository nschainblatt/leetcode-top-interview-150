import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		assert !s.canConstruct("aabc", "ab");
	}
}

class Solution {
	public boolean canConstruct(String ransomNote, String magazine) {
		int[] characterCounter = new int[26];
		int i;
		for (i = 0; i < magazine.length(); i++) {
			characterCounter[magazine.charAt(i) - 'a']++;
		}
		for (i = 0; i < ransomNote.length(); i++) {
			if (characterCounter[ransomNote.charAt(i) - 'a'] == 0) {
				return false;
			}
			characterCounter[ransomNote.charAt(i) - 'a']--;
		}

		return true;
	}
}
