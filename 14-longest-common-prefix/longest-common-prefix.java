class Solution {
    public String longestCommonPrefix(String[] strs) {
        String first = strs[0];

        for (int col = 0; col < first.length(); col++) {
            char c = first.charAt(col);

            for (int row = 1; row < strs.length; row++) {
                if (col == strs[row].length() || strs[row].charAt(col) != c) {
                    return first.substring(0, col);
                }
            }
        }

        return first;
    }
}