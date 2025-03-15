import java.util.*;



public class Main {

	public static void main(String[] args) {

		Solution s = new Solution();

		String actual = s.intToRoman(3749);
		String expected = "MMMDCCXLIX";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(1994);
		expected = "MCMXCIV";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(1902);
		expected = "MCMII";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(1);
		expected = "I";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(2);
		expected = "II";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(3);
		expected = "III";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(4);
		expected = "IV";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(5);
		expected = "V";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(6);
		expected = "VI";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(19);
		expected = "XIX";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);

		actual = s.intToRoman(40);
		expected = "XL";
		assert expected.equals(actual) : String.format("expected: %s actual: %s", expected, actual);
	}
}

class Solution {
	public String intToRoman(int num) {
		String roman = "";
		String[] romanNumerals = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
		int[] integerValues = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };

		int index = romanNumerals.length - 1;
		while (index >= 0 && num > 0) {
			int integer = integerValues[index];
			String newRoman = romanNumerals[index];

			int q = num / integer;
			for (int i = 0; i < q; i++) {
				roman += newRoman;
			}

			num %= integer;
			index--;
		}

		return roman;
	}
}
