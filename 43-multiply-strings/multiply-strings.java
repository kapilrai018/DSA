class Solution {
    public String multiply(String num1, String num2) {

        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = a * b + pos[i + j + 1];
                pos[i + j + 1] = sum % 10;
                pos[i + j] += sum / 10;
            }
        }

        StringBuilder result = new StringBuilder();
        for (int digit : pos) {
            if (result.length() == 0 && digit == 0) {
                continue;
            }
            result.append(digit);
        }

        return result.length() == 0 ? "0" : result.toString();
    }
}
