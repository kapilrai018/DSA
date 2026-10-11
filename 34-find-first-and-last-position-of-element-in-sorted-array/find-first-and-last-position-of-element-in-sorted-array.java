class Solution {
    public int[] searchRange(int[] nums, int target) {
      
        int start = lowerBound(nums, target);

        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }

        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound(int[] nums, int x) {
        int lo = 0;
        int hi = nums.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }

        return lo;
    }
}
