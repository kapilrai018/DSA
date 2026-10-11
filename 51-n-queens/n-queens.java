class Solution {
    private int n;
    private int[] queenCol;
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        this.queenCol = new int[n];
        this.result = new ArrayList<>();
        place(0, 0, 0, 0);
        return result;
    }

    private void place(int row, int cols, int diag, int anti) {
        if (row == n) {
            result.add(draw());
            return;
        }

        int free = ~(cols | diag | anti) & ((1 << n) - 1);

        while (free != 0) {
            int bit = free & -free;
            free ^= bit;

            queenCol[row] = Integer.numberOfTrailingZeros(bit);
            place(row + 1, cols | bit, (diag | bit) << 1, (anti | bit) >> 1);
        }
    }

    private List<String> draw() {
        List<String> board = new ArrayList<>(n);

        for (int r = 0; r < n; r++) {
            char[] line = new char[n];
            Arrays.fill(line, '.');
            line[queenCol[r]] = 'Q';
            board.add(new String(line));
        }

        return board;
    }
}