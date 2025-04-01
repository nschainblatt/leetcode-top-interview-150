import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		// No assertions since the description allows any order to be returned.
	}
}

class Solution {
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> anagrams = new ArrayList<>();
		Map<List<Character>, Integer> indicator = new HashMap<>();

		for (String s : strs) {
			List<Character> chars = s.chars().sorted().mapToObj(i -> (char) i).toList();
			if (indicator.containsKey(chars)) {
				anagrams.get(indicator.get(chars)).add(s);
			} else {
				int insertionIndex = anagrams.size();
				anagrams.add(new ArrayList<String>(List.of(s)));
				indicator.put(chars, insertionIndex);
			}
		}

		return anagrams;
	}
}
