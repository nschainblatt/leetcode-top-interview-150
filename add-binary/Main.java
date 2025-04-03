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

		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while (i >= 0 && j >= 0) {

			char ac = a.charAt(i);
			char bc = b.charAt(j);

			if (ac == '1' && bc == '1') {
				if (carry == 1) {
					s.append('1');
				} else {
					s.append('0');
				}
				carry = 1;
			} else if (ac == '0' && bc == '0') {
				if (carry == 1) {
					s.append('1');
				} else {
					s.append('0');
				}
				carry = 0;
			} else {
				if (carry == 1) {
					s.append('0');
					carry = 1;
				} else {
					s.append('1');
					carry = 0;
				}
			}

			i--;
			j--;
		}

		while (i >= 0) {
			char ac = a.charAt(i);
			if (carry == 1) {
				if (ac == '1') {
					s.append('0');
				} else {
					s.append('1');
					carry = 0;
				}
			} else {
				s.append(ac);
			}
			i--;
		}
		while (j >= 0) {
			char bc = b.charAt(j);
			if (carry == 1) {
				if (bc == '1') {
					s.append('0');
				} else {
					s.append('1');
					carry = 0;
				}
			} else {
				s.append(bc);
			}
			j--;
		}

		if (carry == 1) {
			s.append('1');
		}

		return s.reverse().toString();
	}
}
