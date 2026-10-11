class Solution {
    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int value = 1;

        while (top <= bottom && left <= right) {
            for (int c = left; c <= right; c++) {
                grid[top][c] = value++;
            }
            top++;

            for (int r = top; r <= bottom; r++) {
                grid[r][right] = value++;
            }
            right--;

            if (top <= bottom) {
                for (int c = right; c >= left; c--) {
                    grid[bottom][c] = value++;
                }
                bottom--;
            }

            if (left <= right) {
                for (int r = bottom; r >= top; r--) {
                    grid[r][left] = value++;
                }
                left++;
            }
        }

        return grid;
    }
}