class Solution {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int[] stack = new int[cols + 1];
        int best = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                heights[c] = (matrix[r][c] == '1') ? heights[c] + 1 : 0;
            }

            int top = -1;
            for (int i = 0; i <= cols; i++) {
                int current = (i == cols) ? 0 : heights[i];

                while (top >= 0 && heights[stack[top]] > current) {
                    int height = heights[stack[top--]];
                    int left = (top < 0) ? -1 : stack[top];
                    best = Math.max(best, height * (i - left - 1));
                }

                stack[++top] = i;
            }
        }

        return best;
    }
}