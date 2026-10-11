class Solution {
    private int[] rows = new int[9];
    private int[] cols = new int[9];
    private int[] boxes = new int[9];
    private int[][] empty = new int[81][2];
    private int emptyCount;
    private char[][] grid;
     public void solveSudoku(char[][] board) {
        grid = board;
        emptyCount = 0;
        java.util.Arrays.fill(rows, 0);
        java.util.Arrays.fill(cols, 0);
        java.util.Arrays.fill(boxes, 0);

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] == '.') {
                    empty[emptyCount][0] = r;
                    empty[emptyCount][1] = c;
                    emptyCount++;
                } else {
                    flip(r, c, 1 << (board[r][c] - '1'));
                }
            }
        }

        solve(0);
    }

    private boolean solve(int idx) {
        if (idx == emptyCount) {
            return true;
        }

        int best = idx;
        int bestCount = 10;
        for (int i = idx; i < emptyCount; i++) {
            int count = Integer.bitCount(available(empty[i][0], empty[i][1]));
            if (count < bestCount) {
                bestCount = count;
                best = i;
                if (count <= 1) {
                    break;
                }
            }
        }

        if (bestCount == 0) {
            return false;
        }

        int[] tmp = empty[idx];
        empty[idx] = empty[best];
        empty[best] = tmp;

        int r = empty[idx][0];
        int c = empty[idx][1];
        int mask = available(r, c);

        while (mask != 0) {
            int bit = mask & -mask;
            mask ^= bit;

            flip(r, c, bit);
            grid[r][c] = (char) ('1' + Integer.numberOfTrailingZeros(bit));

            if (solve(idx + 1)) {
                return true;
            }

            flip(r, c, bit);
            grid[r][c] = '.';
        }

        return false;
    }

    private int available(int r, int c) {
        return ~(rows[r] | cols[c] | boxes[(r / 3) * 3 + c / 3]) & 0x1FF;
    }

    private void flip(int r, int c, int bit) {
        rows[r] ^= bit;
        cols[c] ^= bit;
        boxes[(r / 3) * 3 + c / 3] ^= bit;
    }
}
