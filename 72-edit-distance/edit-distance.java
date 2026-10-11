class Solution {
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }

        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= m; i++) {
            int diagonal = dp[0];
            dp[0] = i;

            for (int j = 1; j <= n; j++) {
                int above = dp[j];

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[j] = diagonal;
                } else {
                    dp[j] = 1 + Math.min(diagonal, Math.min(above, dp[j - 1]));
                }

                diagonal = above;
            }
        }

        return dp[n];
    }
}