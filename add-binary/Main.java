import java.util.*;

public class Main {
	public static void main(String[] args) {
		Solution s = new Solution();
		String actual = s.addBinary("11", "1");
		assert "100".equals(actual) : actual;
	}
}

class Solution {
	public String addBinary(String a, String b) {
		StringBuilder s = new StringBuilder();


		// NOTE: have to reverse to get the least significant bit to line up for addition.
		a = new StringBuilder(a).reverse().toString();
		b = new StringBuilder(b).reverse().toString();

		int carry = 0;
		for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
			int ac = i < a.length() ? a.charAt(i) - '0' : 0;
			int bc = i < b.length() ? b.charAt(i) - '0' : 0;

			int total = ac + bc + carry;
			s.append(Integer.toString(total % 2));
			carry = total / 2;
		}

		if (carry == 1) {
			s.append('1');
		}

		return s.reverse().toString();
	}
}
