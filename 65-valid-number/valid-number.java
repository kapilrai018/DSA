class Solution {
    public boolean isNumber(String s) {
        boolean digitSeen = false;
        boolean dotSeen = false;
        boolean expSeen = false;
        boolean digitAfterExp = true;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c >= '0' && c <= '9') {
                digitSeen = true;
                if (expSeen) {
                    digitAfterExp = true;
                }
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                if (dotSeen || expSeen) {
                    return false;
                }
                dotSeen = true;
            } else if (c == 'e' || c == 'E') {
                if (expSeen || !digitSeen) {
                    return false;
                }
                expSeen = true;
                digitAfterExp = false;
            } else {
                return false;
            }
        }

        return digitSeen && digitAfterExp;
    }
}