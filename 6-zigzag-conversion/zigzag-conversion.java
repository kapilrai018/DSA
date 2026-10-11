class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }

        int cycle = 2 * (numRows - 1);
        StringBuilder result = new StringBuilder(n);

        for (int row = 0; row < numRows; row++) {
            for (int start = 0; start + row < n; start += cycle) {
                result.append(s.charAt(start + row));

                boolean middleRow = row > 0 && row < numRows - 1;
                int diagonal = start + cycle - row;
                if (middleRow && diagonal < n) {
                    result.append(s.charAt(diagonal));
                }
            }
        }

        return result.toString();
    }
}
