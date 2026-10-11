class Solution {
    private char[][] grid;
    private char[] target;
    private int rows;
    private int cols;

    public boolean exist(char[][] board, String word) {
        grid = board;
        rows = board.length;
        cols = board[0].length;
        target = word.toCharArray();

        int[] have = new int[128];
        for (char[] row : board) {
            for (char c : row) {
                have[c]++;
            }
        }

        int[] want = new int[128];
        for (char c : target) {
            if (++want[c] > have[c]) {
                return false;
            }
        }

        if (have[target[0]] > have[target[target.length - 1]]) {
            for (int i = 0, j = target.length - 1; i < j; i++, j--) {
                char temp = target[i];
                target[i] = target[j];
                target[j] = temp;
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (search(r, c, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int r, int c, int pos) {
        if (grid[r][c] != target[pos]) {
            return false;
        }
        if (pos == target.length - 1) {
            return true;
        }

        char saved = grid[r][c];
        grid[r][c] = '#';

        boolean found = (r > 0 && search(r - 1, c, pos + 1))
                || (r < rows - 1 && search(r + 1, c, pos + 1))
                || (c > 0 && search(r, c - 1, pos + 1))
                || (c < cols - 1 && search(r, c + 1, pos + 1));

        grid[r][c] = saved;
        return found;
    }
}