class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (n > m) {
            return "";
        }

        int[] need = new int[128];
        for (int i = 0; i < n; i++) {
            need[t.charAt(i)]++;
        }

        int missing = n;
        int bestStart = 0;
        int bestLen = Integer.MAX_VALUE;
        int left = 0;

        for (int right = 0; right < m; right++) {
            if (need[s.charAt(right)] > 0) {
                missing--;
            }
            need[s.charAt(right)]--;

            while (missing == 0) {
                if (right - left + 1 < bestLen) {
                    bestLen = right - left + 1;
                    bestStart = left;
                }

                need[s.charAt(left)]++;
                if (need[s.charAt(left)] > 0) {
                    missing++;
                }
                left++;
            }
        }

        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}