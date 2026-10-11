class Solution {
    public String getPermutation(int n, int k) {
        int[] fact = new int[n];
        fact[0] = 1;
        for (int i = 1; i < n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        StringBuilder digits = new StringBuilder();
        for (int d = 1; d <= n; d++) {
            digits.append(d);
        }

        StringBuilder result = new StringBuilder();
        k--;

        for (int i = n - 1; i >= 0; i--) {
            int index = k / fact[i];
            k %= fact[i];

            result.append(digits.charAt(index));
            digits.deleteCharAt(index);
        }

        return result.toString();
    }
}