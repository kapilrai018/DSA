class Solution {
    public String countAndSay(int n) {
        String current = "1";

        for (int step = 2; step <= n; step++) {
            StringBuilder next = new StringBuilder();
            int i = 0;

            while (i < current.length()) {
                char digit = current.charAt(i);
                int run = 0;

                while (i < current.length() && current.charAt(i) == digit) {
                    run++;
                    i++;
                }

                next.append(run).append(digit);
            }

            current = next.toString();
        }

        return current;
    }
}
