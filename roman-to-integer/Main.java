import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();

		int output = s.romanToInt("MMM");
		assert 3000 == output : output;
		System.out.println("Passed 1");

		output = s.romanToInt("MCMXCIV");
		assert 1994 == output : String.format("%d != %d", 1994, output);
		System.out.println("Passed 2");

		output = s.romanToInt("III");
		assert 3 == output : String.format("%d != %d", 3, output);
		System.out.println("Passed 3");

		output = s.romanToInt("I");
		assert 1 == output : String.format("%d != %d", 1, output);
		System.out.println("Passed 4");

		output = s.romanToInt("DCXXI");
		assert 621 == output : String.format("%d != %d", 621, output);
		System.out.println("Passed 5");

		output = s.romanToInt("MDCCCLXXXIV");
		assert 1884 == output : String.format("%d != %d", 1884, output);
		System.out.println("Passed 6");

		output = s.romanToInt("II");
		assert 2 == output : String.format("%d != %d", 2, output);
		System.out.println("Passed 7");
	}
}

class Solution {
    public int romanToInt(String s) {
        int sum = 0;
        int previousValue = getIntegerFromRomanNumber(s.charAt(0));

        for (int i = 1; i < s.length(); i++) {
            int currentValue = getIntegerFromRomanNumber(s.charAt(i));

            if (currentValue > previousValue) {
                sum -= previousValue;
            } else {
                sum += previousValue;
            }

            previousValue = currentValue;
        }

        sum += previousValue;

        return sum;
    }

    private int getIntegerFromRomanNumber(char r) {
        return switch (r) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }
}
