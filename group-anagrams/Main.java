import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		s.groupAnagrams(new String[] { "eat", "tea", "c", "a", "", "", "abc", "cab" });
		// No assertions since the description allows any order to be returned.
	}
}

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> anagrams = new ArrayList<>();
		Map<List<Integer>, Integer> indicator = new HashMap<>();

		for (int i = 0; i < strs.length; i++) {
			List<Integer> characterCounter = new ArrayList<>(Collections.nCopies(26, 0));
			String s = strs[i];
			for (int j = 0; j < s.length(); j++) {
				characterCounter.set(s.charAt(j) - 'a', characterCounter.get(s.charAt(j) - 'a') + 1);
			}
			if (indicator.containsKey(characterCounter)) {
				int index = indicator.get(characterCounter);
				anagrams.get(index).add(s);
			} else {
				int newIndex = anagrams.size();
				anagrams.add(new ArrayList<>(List.of(s)));
				indicator.put(characterCounter, newIndex);
			}
		}

		return anagrams;
	}
}
