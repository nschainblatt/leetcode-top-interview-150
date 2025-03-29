import java.util.*;

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
		// build a two-dimensional array with numRows
		List<List<String>> matrix = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			matrix.add(new ArrayList<>());
			for (int j = 0; j < s.length(); j++) {
				matrix.get(i).add(""); // Have each nested list have available indices of the lenght of
							// the string (don't need this many)
			}
		}

		// insert characters from string into zig-zag indices
		int col = 0;
		int row = 0;
		boolean up = false;
		for (int i = 0; i < s.length(); i++) {
			String t = String.valueOf(s.charAt(i));
			matrix.get(row).add(col, t);
			if (numRows > 1) {

				if (row == numRows - 1) {
					up = true;
				} else if (row == 0) {
					up = false;
				}

				if (up) {
					col++;
					row--;
				} else {
					row++;
				}

			} else {
				col++;
			}

			// printMatrix(matrix);
			// System.out.println();
		}
		// read line by line and ignore blanks
		// theres your answer
		String o = "";
		for (List<String> line : matrix) {
			for (String letter : line) {
				if (!letter.isEmpty()) {
					o += letter;
				}
			}
		}

		return o;
	}

	private void printMatrix(List<List<String>> matrix) {
		for (List<String> row : matrix) {
			System.out.println(row);
		}
	}
}
