class Solution {
    private int full;

    public int totalNQueens(int n) {
        full = (1 << n) - 1;
        return count(0, 0, 0);
    }

    private int count(int cols, int diag, int anti) {
        if (cols == full) {
            return 1;
        }

        int total = 0;
        int free = ~(cols | diag | anti) & full;

        while (free != 0) {
            int bit = free & -free;
            free ^= bit;
            total += count(cols | bit, ((diag | bit) << 1) & full, (anti | bit) >> 1);
        }

        return total;
    }
}