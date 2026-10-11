class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int len = 2 * n + 1;
        char[] t = new char[len];
        for (int i = 0; i < len; i++) {
            t[i] = (i % 2 == 0) ? '#' : s.charAt(i / 2);
        }

        int[] p = new int[len];
        int center = 0;
        int right = 0;
        int bestLen = 0;
        int bestCenter = 0;

        for (int i = 0; i < len; i++) {
            if (i < right) {
                p[i] = Math.min(right - i, p[2 * center - i]);
            }

            while (i - p[i] - 1 >= 0 && i + p[i] + 1 < len
                    && t[i - p[i] - 1] == t[i + p[i] + 1]) {
                p[i]++;
            }

            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            if (p[i] > bestLen) {
                bestLen = p[i];
                bestCenter = i;
            }
        }

        int start = (bestCenter - bestLen) / 2;
        return s.substring(start, start + bestLen);
    }
}