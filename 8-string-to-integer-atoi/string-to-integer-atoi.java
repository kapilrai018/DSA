class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;
        if (i < n && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        int result = 0;
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }

            int digit = c - '0';
            if (result > Integer.MAX_VALUE / 10
                    || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            result = result * 10 + digit;
            i++;
        }

        return result *sign;
    }
}