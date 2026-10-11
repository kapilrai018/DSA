
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        backtrack(s, 0, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int index, int parts,
                           List<String> path, List<String> ans) {
        if (parts == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {
            String part = s.substring(index, index + len);

            if (part.length() > 1 && part.charAt(0) == '0') {
                break;
            }

            if (Integer.parseInt(part) > 255) {
                break;
            }

            path.add(part);
            backtrack(s, index + len, parts + 1, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
