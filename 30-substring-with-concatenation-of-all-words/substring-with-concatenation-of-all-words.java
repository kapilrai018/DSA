class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

    List<Integer> result = new ArrayList<>();
        int n = s.length();
        int count = words.length;
        int len = words[0].length();

        if (count * len > n) {
            return result;
        }

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) {
            need.merge(w, 1, Integer::sum);
        }

        for (int offset = 0; offset < len; offset++) {
            Map<String, Integer> seen = new HashMap<>();
            int left = offset;
            int used = 0;

            for (int right = offset; right + len <= n; right += len) {
                String word = s.substring(right, right + len);

                if (!need.containsKey(word)) {
                    seen.clear();
                    used = 0;
                    left = right + len;
                    continue;
                }

                seen.merge(word, 1, Integer::sum);
                used++;

                while (seen.get(word) > need.get(word)) {
                    String drop = s.substring(left, left + len);
                    seen.merge(drop, -1, Integer::sum);
                    left += len;
                    used--;
                }

                if (used == count) {
                    result.add(left);
                    String drop = s.substring(left, left + len);
                    seen.merge(drop, -1, Integer::sum);
                    left += len;
                    used--;
                }
            }
        }

        return result;
    }
}
