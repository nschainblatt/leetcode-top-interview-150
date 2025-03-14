import java.util.*;



public class Main {

	public static void main(String[] args) {

		Solution s = new Solution();

		// Tests
		assert s.getFirstDigit(1234) == 1;
		assert s.getFirstDigit(4321) == 4;
		assert s.getFirstDigit(40) == 4 : s.getFirstDigit(40);

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

	public int[] integers = new int[] {1, 5, 10, 50, 100, 500, 1000};

	public int getFirstDigit(int num) {
		while ((int) num > 9) {
			num /= 10;
		}
		return (int) num;
	}

	public String intToRoman(int num) {
		String roman = "";

		while (num > 0) {
			int firstDigit = getFirstDigit(num);
			int index = findIndexOfMaxRomanToSubtract(num);

			int sub = 0;
			String newRoman = "";

			if (firstDigit == 4) {
				// Next half power of 10 minus maximum number to subract e.g. if num is 4xx 500 - 100 or num is 4x 50 - 10
				char prefix = getRomanFromInteger(integers[index]); //10
				char postfix = getRomanFromInteger(integers[index+1]); //50
				sub = integers[index+1] - integers[index];
				newRoman = new String(new char[] {prefix, postfix});
			} else if (firstDigit == 9) {
				// Next power of  10 number minus previous power of 10 number e.g. 1000 - 100 or 100 - 10
				char prefix = getRomanFromInteger(integers[index-1]);
				char postfix = getRomanFromInteger(integers[index+1]);
				sub = integers[index+1] - integers[index-1];
				newRoman = new String(new char[] {prefix, postfix});
			} else {
				// Subtract the highest possible number
				sub = integers[index];
				newRoman += getRomanFromInteger(sub);
			}

			num -= sub;
			roman += newRoman;

		}

		return roman;
	}


	private int findIndexOfMaxRomanToSubtract(int num) {
		int index = integers.length - 1;
		while (num - integers[index] < 0 && index >= 0) {
			index--;
		}

		return index;
	}

	private char getRomanFromInteger(int r) {
		return switch (r) {
			case 1 -> 'I';
			case 5 -> 'V';
			case 10 -> 'X';
			case 50 -> 'L';
			case 100 -> 'C';
			case 500 -> 'D';
			case 1000 -> 'M';
			default -> {
				throw new RuntimeException();
			}
		};
	}
}
