class Solution {
        private static final String[] LETTERS = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };


    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }

        build(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void build(String digits, int pos, StringBuilder current, List<String> result) {
        if (pos == digits.length()) {
            result.add(current.toString());
            return;
        }

        String options = LETTERS[digits.charAt(pos) - '0'];
        for (int i = 0; i < options.length(); i++) {
            current.append(options.charAt(i));
            build(digits, pos + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
}  