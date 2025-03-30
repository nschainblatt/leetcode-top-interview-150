public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String actual = s.convert("PAYPALISHIRING", 4);
		String expected = "PINALSIGYAHRPI";
		assert expected.equals(actual) : String.format("expected: %s, actual: %s", expected, actual);

		actual = s.convert("AB", 1);
		expected = "AB";
		assert expected.equals(actual) : String.format("expected: %s, actual: %s", expected, actual);

	}
}

class Solution {
	public String convert(String s, int numRows) {
		if (numRows == 1) {
			return s;
		}

		StringBuilder o = new StringBuilder();
		int offset = (numRows - 1) * 2;
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length(); j += offset) {
				o.append(s.charAt(j));
				if (i % (numRows - 1) != 0 && j + offset - 2 * i < s.length()) {
					o.append(s.charAt(j + (offset - (2 * i))));
				}
			}
		}

		return o.toString();
	}
}
