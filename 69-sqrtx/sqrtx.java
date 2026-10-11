class Solution {
    public int mySqrt(int x) {
        if (x < 2) {
            return x;
        }

        int lo = 1;
        int hi = x / 2;
        int answer = 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                answer = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return answer;
    }
}