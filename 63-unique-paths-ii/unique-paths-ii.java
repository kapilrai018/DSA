class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] ways = new int[n];
        ways[0] = obstacleGrid[0][0] == 0 ? 1 : 0;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (obstacleGrid[r][c] == 1) {
                    ways[c] = 0;
                } else if (c > 0) {
                    ways[c] += ways[c - 1];
                }
            }
        }

        return ways[n - 1];
    }
}