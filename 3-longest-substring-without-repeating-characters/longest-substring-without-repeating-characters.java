class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastSeen = new int[128];
        int best = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            left = Math.max(left, lastSeen[c]);
            best = Math.max(best, right - left + 1);
            lastSeen[c] = right + 1;
        }

        return best;
    }
}