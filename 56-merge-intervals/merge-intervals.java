class Solution {
    private static final int MAX = 10000;

    public int[][] merge(int[][] intervals) {
        int[] reach = new int[MAX + 1];
        java.util.Arrays.fill(reach, -1);

        for (int[] interval : intervals) {
            if (interval[1] > reach[interval[0]]) {
                reach[interval[0]] = interval[1];
            }
        }

        java.util.List<int[]> merged = new java.util.ArrayList<>();
        int i = 0;

        while (i <= MAX) {
            if (reach[i] < 0) {
                i++;
                continue;
            }

            int start = i;
            int end = reach[i];
            int j = i + 1;

            while (j <= end) {
                if (reach[j] > end) {
                    end = reach[j];
                }
                j++;
            }

            merged.add(new int[]{start, end});
            i = end + 1;
        }

        return merged.toArray(new int[0][]);
    }
}