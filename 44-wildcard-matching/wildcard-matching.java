class Solution {
    public boolean isMatch(String s, String p) {
     
        int m = s.length();
        int n = p.length();
        int i = 0;
        int j = 0;
        int starIdx = -1;
        int resume = 0;

        while (i < m) {
            if (j < n && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
                i++;
                j++;
            } else if (j < n && p.charAt(j) == '*') {
                starIdx = j;
                resume = i;
                j++;
            } else if (starIdx != -1) {
                j = starIdx + 1;
                resume++;
                i = resume;
            } else {
                return false;
            }
        }

        while (j < n && p.charAt(j) == '*') {
            j++;
        }

        return j == n;
    }
}