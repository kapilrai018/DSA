class Solution {
    public int divide(int dividend, int divisor) {

    if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean negative = (dividend < 0) != (divisor < 0);
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);
        long quotient = 0;

        for (int bit = 31; bit >= 0; bit--) {
            if ((a >> bit) >= b) {
                a -= b << bit;
                quotient += 1L << bit;
            }
        }

        return negative ? (int) -quotient : (int) quotient;
    }
}
