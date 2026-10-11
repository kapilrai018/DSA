class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') {
            return 0;
        }

        int twoBack = 1;
        int oneBack = 1;

        for (int i = 2; i <= n; i++) {
            int current = 0;

            if (s.charAt(i - 1) != '0') {
                current += oneBack;
            }

            int pair = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0');
            if (pair >= 10 && pair <= 26) {
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return oneBack;
    }
}