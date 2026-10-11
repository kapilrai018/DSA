class Solution {
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        if (m > n) {
            return -1;
        }

        int[] lps = new int[m];
        int len = 0;
        for (int i = 1; i < m; i++) {
            while (len > 0 && needle.charAt(i) != needle.charAt(len)) {
                len = lps[len - 1];
            }
            if (needle.charAt(i) == needle.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }

        int matched = 0;
        for (int i = 0; i < n; i++) {
            while (matched > 0 && haystack.charAt(i) != needle.charAt(matched)) {
                matched = lps[matched - 1];
            }
            if (haystack.charAt(i) == needle.charAt(matched)) {
                matched++;
            }
            if (matched == m) {
                return i - m + 1;
            }
        }

        return -1;
    }
}
