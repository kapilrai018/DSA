class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] cost = new int[n];

        cost[0] = grid[0][0];
        for (int c = 1; c < n; c++) {
            cost[c] = cost[c - 1] + grid[0][c];
        }

        for (int r = 1; r < m; r++) {
            cost[0] += grid[r][0];
            for (int c = 1; c < n; c++) {
                cost[c] = grid[r][c] + Math.min(cost[c], cost[c - 1]);
            }
        }

        return cost[n - 1];
    }
}